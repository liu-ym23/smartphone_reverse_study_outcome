package com.bytedance.securityguardkit.settingsevent;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class SettingsPolicyObserver extends ContentObserver {
    private static final String AUTHORITY = "com.obric.securityserver.settings";
    private static final String PATH_POLICY_VERSION = "policy_version";
    public static final String SETTING_KEY_SENS_VIEWS = "settings_sens_views";
    public static final String SETTING_KEY_SENS_WORDS = "settings_sens_words";
    private static final String TAG = "SettingsPolicyObserver";
    private static final Uri URI_SENS_VIEWS = null;
    private static final Uri URI_SENS_WORDS = null;
    private final Context mAppContext;
    private final ContentResolver mContentResolver;
    private boolean mHasRegistered;
    private a mListener;

    public interface a {
        void a(String r1);

        void b(String r1);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.d(r0, r1);
    }

    static {
        URI_SENS_WORDS = Uri.parse("content://com.obric.securityserver.settings/policy_version/settings_sens_words");
        URI_SENS_VIEWS = Uri.parse("content://com.obric.securityserver.settings/policy_version/settings_sens_views");
    }

    public SettingsPolicyObserver(Context r3, Handler r4, a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        super(r4);
        this.mHasRegistered = false;
        Context r8 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mAppContext = r8;
        this.mContentResolver = r8.getContentResolver();
        this.mListener = r7;
    }

    public void register() {
        if (this.mHasRegistered == false) goto L12;
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "register: observer has already been registered");
        return;
    L12:
        ZeusProviderTransform.registerContentObserver(this.mContentResolver, URI_SENS_WORDS, false, this, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        ZeusProviderTransform.registerContentObserver(this.mContentResolver, URI_SENS_VIEWS, false, this, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "Registered policy change observer for keys: settings_sens_words, settings_sens_views");
        this.mHasRegistered = true;
        return;
    L9:
        e = move-exception;
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "registerContentObserver failed", e);
    }

    public void unregister() {
        if (this.mHasRegistered == true) goto L12;
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "unregister: observer has not been registered");
        return;
    L12:
        ZeusProviderTransform.unregisterContentObserver(this.mContentResolver, this, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
    L10:
        this.mListener = null;
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "Unregistered policy change observer");
        this.mHasRegistered = false;
        return;
    L8:
        e = move-exception;
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "unregisterContentObserver failed", e);
        goto L10
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r4, Uri r5) {
        super.onChange(r4, r5);
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mListener == null) goto L17;
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "onChange: uri = " + r5);
        String r6 = queryPolicyVersion(r5);
        INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "Policy updated: " + r5 + " -> " + r6);
        String r7 = r5.getLastPathSegment();
        if (SETTING_KEY_SENS_WORDS.equals(r7) == false) goto L11;
        this.mListener.a(r6);
        return;
    L11:
        if (SETTING_KEY_SENS_VIEWS.equals(r7) == false) goto L16;
        this.mListener.b(r6);
        return;
    L16:
        return;
    }

    private String queryPolicyVersion(Uri r8) {
        Cursor r7 = ZeusProviderTransform.query(this.mContentResolver, r8, null, null, null, null, "com.obric.aiagent.plugin");
        if (r7 != null) goto L15;
        return null;
    L15:
    L10:
        th = move-exception;
        r7.close();
        throw th;
    L5:
        if (r7.moveToFirst() == false) goto L9;
        String r9 = r7.getString(r7.getColumnIndexOrThrow("value"));     // Catch: Throwable -> L10
        r7.close();
        return r9;
    L9:
        r7.close();
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_securityguardkit_settingsevent_SettingsPolicyObserver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}

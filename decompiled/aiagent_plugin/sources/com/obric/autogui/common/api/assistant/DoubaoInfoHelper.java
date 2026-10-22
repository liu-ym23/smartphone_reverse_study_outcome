package com.obric.autogui.common.api.assistant;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: DoubaoInfoHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DoubaoInfoHelper {
    private static final String AUTHORITY = "content://com.obric.assistant.provider.ObricAutoAppCommonSettingProvider";
    public static final DoubaoInfoHelper INSTANCE = null;
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    private static final String METHOD_GET = "get_doubao_info";
    private static final String TAG = "DoubaoInfoHelper";
    private static volatile String cachedDeviceId;
    private static volatile String cachedUpdateVersionCode;

    /* JADX INFO: compiled from: DoubaoInfoHelper.kt */
    public static final class DoubaoInfo {
        private final String deviceId;
        private final String updateVersionCode;

        public static /* synthetic */ DoubaoInfo copy$default(DoubaoInfo r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.deviceId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.updateVersionCode;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.deviceId;
        }

        public final String component2() {
            return this.updateVersionCode;
        }

        public final DoubaoInfo copy(String r1, String r2) {
            o.e(r1, "deviceId");
            o.e(r2, "updateVersionCode");
            return new DoubaoInfo(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, DoubaoInfo.class) == true) goto L8;
            return false;
        L8:
            DoubaoInfo r6 = (DoubaoInfo) ZeusTransformUtils.preCheckCast(r5, DoubaoInfo.class, "com.obric.aiagent.plugin");
            if (o.a(this.deviceId, r6.deviceId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.updateVersionCode, r6.updateVersionCode) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.deviceId.hashCode() * 31) + this.updateVersionCode.hashCode();
        }

        public String toString() {
            return "DoubaoInfo(deviceId=" + this.deviceId + ", updateVersionCode=" + this.updateVersionCode + ')';
        }

        public DoubaoInfo(String r2, String r3) {
            o.e(r2, "deviceId");
            o.e(r3, "updateVersionCode");
            this.deviceId = r2;
            this.updateVersionCode = r3;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getUpdateVersionCode() {
            return this.updateVersionCode;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.assistant.DoubaoInfoHelper$getInfo$2, reason: invalid class name */
    /* JADX INFO: compiled from: DoubaoInfoHelper.kt */
    @f(b = "DoubaoInfoHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.assistant.DoubaoInfoHelper$getInfo$2")
    static final class AnonymousClass2 extends l implements m<am, d<? super DoubaoInfo>, Object> {
        final /* synthetic */ Context $context;
        int label;

        AnonymousClass2(Context r3, d<? super AnonymousClass2> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$context = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$context, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super DoubaoInfo> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super DoubaoInfo> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            String r0 = "";
            b.a();
            if (this.label != 0) goto L85;
            d.o.a(r14);
            Loog.INSTANCE.i(DoubaoInfoHelper.TAG, "[GetInfo] enter");
            String r15 = DoubaoInfoHelper.access$getCachedDeviceId$p();
            String r2 = DoubaoInfoHelper.access$getCachedUpdateVersionCode$p();
            boolean r5 = false;
            if (r15 == null) goto L86;
            if (r2 == null) goto L86;
            Loog r13 = Loog.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("[GetInfo] exit cache-hit hasDeviceId=");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
            boolean r7 = true;
        L11:
            StringBuilder r3 = r1.append(r7).append(", hasVersion=");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
            r5 = true;
        L14:
            r13.i(DoubaoInfoHelper.TAG, r3.append(r5).toString());
            return new DoubaoInfo(r15, r2);
        L10:
            r7 = false;
        L86:
            Loog.INSTANCE.i(DoubaoInfoHelper.TAG, "[GetInfo] before contentResolver.call");     // Catch: Exception -> L62
            Bundle r16 = ZeusProviderTransform.call(this.$context.getContentResolver(), Uri.parse(DoubaoInfoHelper.AUTHORITY), DoubaoInfoHelper.METHOD_GET, null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L62
            Loog r17 = Loog.INSTANCE;     // Catch: Exception -> L62
            StringBuilder r4 = new StringBuilder().append("[GetInfo] after contentResolver.call hasBundle=");     // Catch: Exception -> L62
            if (r16 == null) goto L19;
            boolean r8 = true;
        L20:
            r17.i(DoubaoInfoHelper.TAG, r4.append(r8).toString());     // Catch: Exception -> L62
            String r18 = DoubaoInfoHelper.access$getCachedDeviceId$p();     // Catch: Exception -> L62
            String r6 = null;
            if (r18 != null) goto L36;
            if (r16 == null) goto L24;
            r18 = r16.getString("device_id");     // Catch: Exception -> L62
        L25:
            if (r18 != null) goto L27;
            r18 = "";
        L27:
            CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L62
            if (r9 != null) goto L30;
        L33:
            boolean r10 = true;
        L34:
            if (r10 == true) goto L36;
            DoubaoInfoHelper r11 = DoubaoInfoHelper.INSTANCE;     // Catch: Exception -> L62
            DoubaoInfoHelper.access$setCachedDeviceId$p(r18);     // Catch: Exception -> L62
            goto L36
        L30:
            if (r9.length() == 0) goto L33;
            r10 = false;
            goto L34
        L24:
            r18 = null;
        L36:
            String r12 = DoubaoInfoHelper.access$getCachedUpdateVersionCode$p();     // Catch: Exception -> L62
            if (r12 != null) goto L52;
            if (r16 == null) goto L40;
            r6 = r16.getString(DoubaoInfoHelper.KEY_UPDATE_VERSION_CODE);     // Catch: Exception -> L62
        L40:
            if (r6 != null) goto L42;
            r12 = "";
        L43:
            CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L62
            if (r19 != null) goto L46;
        L49:
            boolean r110 = true;
        L50:
            if (r110 == true) goto L52;
            DoubaoInfoHelper r111 = DoubaoInfoHelper.INSTANCE;     // Catch: Exception -> L62
            DoubaoInfoHelper.access$setCachedUpdateVersionCode$p(r12);     // Catch: Exception -> L62
            goto L52
        L46:
            if (r19.length() == 0) goto L49;
            r110 = false;
            goto L50
        L42:
            r12 = r6;
        L52:
            Loog r112 = Loog.INSTANCE;     // Catch: Exception -> L62
            StringBuilder r20 = new StringBuilder().append("[GetInfo] exit provider-return hasDeviceId=");     // Catch: Exception -> L62
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L55;
            boolean r21 = true;
        L56:
            StringBuilder r22 = r20.append(r21).append(", hasVersion=");     // Catch: Exception -> L62
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L59;
            boolean r23 = true;
        L60:
            r112.i(DoubaoInfoHelper.TAG, r22.append(r23).toString());     // Catch: Exception -> L62
            return new DoubaoInfo(r18, r12);
        L59:
            r23 = false;
            goto L60
        L55:
            r21 = false;
            goto L56
        L19:
            r8 = false;
        L62:
            e = move-exception;
            Loog r113 = Loog.INSTANCE;
            StringBuilder r114 = new StringBuilder().append("[GetInfo] exit exception ").append(e.getClass().getSimpleName()).append(", fallbackHasDeviceId=");
            CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(DoubaoInfoHelper.access$getCachedDeviceId$p(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r24 != null) goto L66;
        L69:
            boolean r25 = true;
        L70:
            StringBuilder r115 = r114.append(!r25).append(", fallbackHasVersion=");
            CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(DoubaoInfoHelper.access$getCachedUpdateVersionCode$p(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r26 != null) goto L73;
        L74:
            r5 = true;
        L75:
            r113.i(DoubaoInfoHelper.TAG, r115.append(!r5).toString());
            String r116 = DoubaoInfoHelper.access$getCachedDeviceId$p();
            if (r116 != null) goto L78;
            r116 = "";
        L78:
            String r27 = DoubaoInfoHelper.access$getCachedUpdateVersionCode$p();
            if (r27 == null) goto L83;
            r0 = r27;
        L83:
            return new DoubaoInfo(r116, r0);
        L73:
            if (r26.length() != 0) goto L75;
        L66:
            if (r24.length() == 0) goto L69;
            r25 = false;
            goto L70
        L85:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new DoubaoInfoHelper();
    }

    private DoubaoInfoHelper() {
    }

    public static final /* synthetic */ String access$getCachedDeviceId$p() {
        return cachedDeviceId;
    }

    public static final /* synthetic */ String access$getCachedUpdateVersionCode$p() {
        return cachedUpdateVersionCode;
    }

    public static final /* synthetic */ void access$setCachedDeviceId$p(String r0) {
        cachedDeviceId = r0;
    }

    public static final /* synthetic */ void access$setCachedUpdateVersionCode$p(String r0) {
        cachedUpdateVersionCode = r0;
    }

    public final Object getInfo(Context r4, d<? super DoubaoInfo> r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3, null), m.class, "com.obric.aiagent.plugin"), r6);
    }
}

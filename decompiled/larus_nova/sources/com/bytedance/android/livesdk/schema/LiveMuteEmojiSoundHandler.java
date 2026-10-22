package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/schema/LiveMuteEmojiSoundHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "Lcom/bytedance/android/livesdk/schema/LiveMuteEmojiSoundHandler$Model;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "getSchemaParams", "", "", "schemaString", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "muteEmojiSound", "", "Companion", ExifInterface.TAG_MODEL, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMuteEmojiSoundHandler implements IBaseSchemaHandler<Model> {
    private static final Companion Companion = null;
    private static final String TAG = "LiveMuteEmojiSoundHandler";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/schema/LiveMuteEmojiSoundHandler$Companion;", "", "()V", "TAG", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/schema/LiveMuteEmojiSoundHandler$Model;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "getSchemaHost", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Model extends BaseSchemaModel {
        @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
        public String getSchemaHost() {
            return SchemaHandlerHostConstants.LIVE_MUTE_EMOJI_SOUND;
        }

        public Model() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LiveMuteEmojiSoundHandler() {
    }

    private final Map<String, String> getSchemaParams(String r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r101;
    L11:
        Uri r103 = UriProtector.parse(r100);
        Set<String> r104 = UriProtector.getQueryParameterNames(r103);
        if (r104 != null) goto L14;
        return r101;
    L14:
        Iterator<T> r105 = r104.iterator();
    L16:
        if (r105.hasNext() == false) goto L21;
        String r106 = (String) r105.next();
        String r107 = UriProtector.getQueryParameter(r103, r106);
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        r101.put(r106, r107);
        goto L16
    L21:
        return r101;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    private final void muteEmojiSound(Model r100) {
        if (r100 == null) goto L6;
        Uri r101 = r100.getUri();
        if (r101 == null) goto L6;
        String r102 = r101.toString();
    L7:
        String r103 = getSchemaParams(r102).get(ITTVideoEngineEventSource.KEY_MUTE);
        if (r103 != null) goto L10;
        r103 = "false";
    L10:
        boolean r104 = TextUtils.equals(r103, "true");
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r105 = com.bytedance.android.livesdk.sharedpref.c.f158250a1;
        Boolean r106 = Boolean.valueOf(!r104);
        r105.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r105, r106);
        return;
    L6:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getHost();
    L6:
        return Intrinsics.areEqual(SchemaHandlerHostConstants.LIVE_MUTE_EMOJI_SOUND, r101);
    L4:
        r101 = null;
        goto L6
    }

    public boolean handle(Context r100, Model r101) {
        if (r100 != null) goto L6;
        ALogger.e(TAG, "error, context is null");
        return true;
    L6:
        muteEmojiSound(r101);
        return true;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (Model) r101);
    }
}

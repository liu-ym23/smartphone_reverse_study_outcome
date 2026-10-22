package com.bytedance.applet.event;

import androidx.collection.LruCache;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.clienttool.ClientToolRunner;
import com.bytedance.ai.model.d0;
import com.bytedance.ai.model.e0;
import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.model.objects.RealData;
import com.bytedance.ai.model.x;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.stop.PendingAppletActionCancellation;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements w4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f191812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.ai.uiu.l f191813b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f191814c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<o> f191815d = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applet/event/BaseAppActionListener$SnapshotAppActionContent;", "", "action", "", "key", "timeoutMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAction", "()Ljava/lang/String;", "getKey", "getTimeoutMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/applet/event/BaseAppActionListener$SnapshotAppActionContent;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("action")
        private final String action;

        @SerializedName("key")
        private final String key;

        @SerializedName(LocationMonitorConst.TIMEOUT_MS)
        private final Integer timeoutMs;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.action, r101.action) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.timeoutMs, r101.timeoutMs) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.action;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.key;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.timeoutMs;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SnapshotAppActionContent(action=" + this.action + ", key=" + this.key + ", timeoutMs=" + this.timeoutMs + ')';
        }

        public a() {
            this.action = null;
            this.key = null;
            this.timeoutMs = null;
        }

        public final String a() {
            return this.action;
        }

        public final String b() {
            return this.key;
        }

        public final Integer c() {
            return this.timeoutMs;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\b\u0082\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/applet/event/BaseAppActionListener$SnapshotAppActionResponse;", "", "key", "", "uploaded", "", DBDefinition.MIME_TYPE, "width", "", "height", "errorCode", "errorMsg", "<init>", "(Ljava/lang/String;ZLjava/lang/String;IIILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getUploaded", "()Z", "getMimeType", "getWidth", "()I", "getHeight", "getErrorCode", "getErrorMsg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("error_code")
        private final int errorCode;

        @SerializedName("error_msg")
        private final String errorMsg;

        @SerializedName("height")
        private final int height;

        @SerializedName("key")
        private final String key;

        @SerializedName("mime_type")
        private final String mimeType;

        @SerializedName("uploaded")
        private final boolean uploaded;

        @SerializedName("width")
        private final int width;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.uploaded == r101.uploaded) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.mimeType, r101.mimeType) == true) goto L18;
            return false;
        L18:
            if (this.width == r101.width) goto L21;
            return false;
        L21:
            if (this.height == r101.height) goto L24;
            return false;
        L24:
            if (this.errorCode == r101.errorCode) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            if (this.uploaded == false) goto L5;
            int r101 = 1231;
        L7:
            return ((((((((((r100 + r101) * 31) + this.mimeType.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.errorCode) * 31) + this.errorMsg.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "SnapshotAppActionResponse(key=" + this.key + ", uploaded=" + this.uploaded + ", mimeType=" + this.mimeType + ", width=" + this.width + ", height=" + this.height + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
        }

        public b(String r100, boolean r101, String r102, int r103, int r104, int r105, String r110, int r111) {
            if ((r111 & 4) == 0) goto L6;
            r102 = "";
        L6:
            if ((r111 & 8) == 0) goto L9;
            r103 = 0;
        L9:
            if ((r111 & 16) == 0) goto L12;
            r104 = 0;
        L12:
            if ((r111 & 32) == 0) goto L15;
            r105 = 0;
        L15:
            if ((r111 & 64) == 0) goto L17;
            r110 = "";
        L17:
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, DBDefinition.MIME_TYPE);
            Intrinsics.checkNotNullParameter(r110, "errorMsg");
            this.key = r100;
            this.uploaded = r101;
            this.mimeType = r102;
            this.width = r103;
            this.height = r104;
            this.errorCode = r105;
            this.errorMsg = r110;
        }
    }

    public e() {
    }

    static {
        e r100 = new e();
        f191812a = r100;
        f191813b = new com.bytedance.ai.uiu.l();
        f191814c = new Gson();
        ArrayList r101 = new ArrayList();
        f191815d = r101;
        Intrinsics.checkNotNullParameter(r100, "appActionListener");
        r101.add(new com.bytedance.applet.utils.e());
        PendingAppletActionCancellation r102 = PendingAppletActionCancellation.f309941a;
        PendingAppletActionCancellation.a r103 = new d();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "revoker");
        PendingAppletActionCancellation.f309943c.add(r103);
    }

    public static String e(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("code", r100);
        r103.put("msg", r101);
        r103.put("data", r102);
        return r103.toString();
    }

    @Override // w4.a
    public final void c(String r110, String r111, String r112, j r113) {
        Intrinsics.checkNotNullParameter(r111, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r112, "questionId");
        Intrinsics.checkNotNullParameter(r113, "responseCallback");
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L5
        Object r115 = Result.m9449constructorimpl((a) f191814c.fromJson(r110, a.class));     // Catch: Throwable -> L5
    L7:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 != null) goto L41;
        a r117 = (a) r115;
        if (r117 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r117.a(), "get_current_page_screenshot") == false) goto L45;
        String r118 = r117.b();
        boolean r119 = true;
        if (r118 != null) goto L17;
    L20:
        boolean r120 = true;
    L21:
        if (r120 == false) goto L27;
        Gson r121 = f191814c;
        String r122 = r117.b();
        if (r122 != null) goto L25;
        r122 = "";
    L25:
        r113.invoke(e(-1, "messageId is empty", GsonProtectorUtils.toJson(r121, new b(r122, false, null, 0, 0, -1, "messageId is empty", 28))));
        return;
    L27:
        String r100 = r117.b();
        Integer r123 = r117.c();
        if (r123 != null) goto L30;
    L38:
        long r124 = 5000;
    L39:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseAppActionListener$onUndefinedAction$1(r124, r100, r113, null), 3, null);
        return;
    L30:
        if (r123.intValue() > 0) goto L33;
        r119 = false;
    L33:
        if (r119 == true) goto L36;
        r123 = null;
    L36:
        if (r123 == null) goto L38;
        r124 = r123.intValue();
        goto L39
    L17:
        if (r118.length() == 0) goto L20;
        r120 = false;
        goto L21
    L45:
        return;
    L41:
        FLogger.f375446a.e("BaseAppActionListener", "parse undefined app action error " + r116);
        return;
    L5:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // w4.a
    public final void a(String r210, String r211, String r212, String r213, String r214, Map r215, String r216, String r310, Long r311, Integer r312, j r313) {
        Intrinsics.checkNotNullParameter(r210, "botId");
        Intrinsics.checkNotNullParameter(r211, "conversationId");
        Intrinsics.checkNotNullParameter(r212, "appId");
        Intrinsics.checkNotNullParameter(r213, "apiName");
        Intrinsics.checkNotNullParameter(r214, "param");
        Intrinsics.checkNotNullParameter(r216, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r310, "questionId");
        Intrinsics.checkNotNullParameter(r313, "responseCallback");
        FLogger.f375446a.i("BaseAppActionListener", "begin to handle ui action questionId " + r310 + " apiName " + r213);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseAppActionListener$onUIAction$1(r210, r211, r212, r213, r214, r215, r216, r310, r311, BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseAppActionListener$onUIAction$job$1(r312, r310, r213, r313, r216, r210, r211, r212, null), 3, null), r313, null), 3, null);
    }

    @Override // w4.a
    public final void b(String r100, String r101, String r102, String r103, String r104, Map r105, String r106, String r107, Long r108, Integer r110, j r111) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "eventName");
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r106, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r107, "questionId");
        Intrinsics.checkNotNullParameter(r111, "responseCallback");
        com.bytedance.ai.monitor.b.d("app_action", new f(r106, r107));
        r111.invoke(e(0, "success", null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.applet.event.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.bytedance.applet.event.a] */
    /* JADX WARN: Type inference failed for: r7v8, types: [com.bytedance.ai.model.x] */
    public static final Object d(e r110, String r210, String r211, String r212, String r213, String r214, Map r215, String r216, String r217, Long r218, g r219, Continuation r310) {
        String r100 = r216;
        String r101 = r217;
        r110.getClass();
        if ((r310 instanceof BaseAppActionListener$processUIAction$1) == false) goto L7;
        BaseAppActionListener$processUIAction$1 r102 = (BaseAppActionListener$processUIAction$1) r310;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        Function1 r108 = (Function1) r102.L$8;
        Long r109 = (Long) r102.L$7;
        String r111 = (String) r102.L$6;
        String r112 = (String) r102.L$5;
        Map r113 = (Map) r102.L$4;
        String r114 = (String) r102.L$3;
        String r115 = (String) r102.L$2;
        String r116 = (String) r102.L$1;
        String r117 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
        final Function1 r118 = r108;
        Long r119 = r109;
        r100 = r112;
        String r120 = r117;
        Map r121 = r113;
        String r122 = r116;
        String r123 = r114;
        String r124 = r115;
    L37:
        String r125 = (String) r104;
        r101 = r111;
    L40:
        PendingAppletActionCancellation.f309941a.getClass();
        if (PendingAppletActionCancellation.f309944d == false) goto L51;
        List r126 = CollectionsKt.listOf(new String[]{r101, r100});
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L45:
        if (r128.hasNext() == false) goto L49;
        String r129 = PendingAppletActionCancellation.e((String) r128.next());
        if (r129 == null) goto L45;
        r127.add(r129);
        goto L45
    L49:
        Set r130 = CollectionsKt.toSet(r127);
        if (r130.isEmpty() == true) goto L51;
        boolean r131 = PendingAppletActionCancellation.d(r130, PendingAppletActionCancellation.e(r125));
    L53:
        LLMData r132 = null;
        if (r131 == false) goto L56;
        FLogger.f375446a.i("BaseAppActionListener", "ignore applet ui action after user stop, appId=" + r122 + " apiName=" + r124 + " questionId=" + r101 + " msgId=" + r100 + " conversationId=" + r125);
        r118.invoke(e(0, "interrupted", null));
        return Unit.INSTANCE;
    L56:
        Iterator r133 = ((ArrayList) f191815d).iterator();
    L58:
        if (r133.hasNext() == false) goto L62;
        o r134 = (o) r133.next();
        if (r134.a(r124) == false) goto L58;
        FLogger.f375446a.i("BaseAppActionListener", "intercept ui action apiName " + r124 + " by " + r134.getClass().getSimpleName());
        r134.b(r120, r125, r122, r124, r123, r100, r101, new com.bytedance.applet.event.a(r118));
        return Unit.INSTANCE;
    L62:
        com.bytedance.ai.uiu.l r135 = f191813b;
        r135.getClass();
        Intrinsics.checkNotNullParameter(r124, "apiName");
        if (Intrinsics.areEqual(r124, "system_ui_understanding_plugin.system_do_view_operations_tool") == false) goto L65;
    L68:
        boolean r136 = true;
    L69:
        if (r136 == false) goto L71;
        r135.a(r120, r122, r125, r124, r123, new com.bytedance.applet.event.b(r118));
        return Unit.INSTANCE;
    L71:
        AppletRuntimeManager r137 = AppletRuntimeManager.INSTANCE;
        if (r119 == null) goto L74;
        long r138 = r119.longValue();
    L75:
        final h5.g r139 = new h5.g(r123, r100, r125, r120, r138, r101, r124, r121, r122);
        final ?? r140 = new c(r118);
        r137.getClass();
        Intrinsics.checkNotNullParameter(r139, "data");
        Intrinsics.checkNotNullParameter(r140, "appActionCallback");
        final long r141 = System.currentTimeMillis();
        LruCache<Long, com.bytedance.ai.utils.j.a> r142 = com.bytedance.ai.utils.j.f37639a;
        final com.bytedance.ai.utils.j.a r143 = com.bytedance.ai.utils.j.b(Long.valueOf(CastLongProtector.parseLong(r139.f483819b)));
        if (r143 == null) goto L81;
        com.bytedance.ai.utils.j.c r144 = r143.f37651k;
        if (r144 == null) goto L81;
        r144.a();
    L81:
        if (r139.f483821d.length() != 0) goto L83;
        r107 = true;
    L83:
        if (r107 == false) goto L86;
        String r145 = AppletRuntimeManager.h(r139.f483820c);
        Intrinsics.checkNotNullParameter(r145, "<set-?>");
        r139.f483821d = r145;
    L86:
        if (r139.f483827j == null) goto L128;
    L106:
        final LLMData r146 = r139.f483827j;
        String r147 = r139.f483821d;
        ConcurrentHashMap<String, String> r148 = x4.a.f562420a;
        String r149 = r139.f483820c;
        Intrinsics.checkNotNullParameter(r149, "sessionId");
        if (r147 == null) goto L110;
        x4.a.f562420a.putIfAbsent(r147, r149);
    L110:
        com.bytedance.ai.monitor.b.d("applet_llm_msg_received", new d0(r146, r147, r139));
        com.bytedance.ai.utils.g r150 = com.bytedance.ai.utils.g.f37637a;
        r150.i("applet_lifecycle", "<parseMessage><msgId-" + r139.f483819b + "> message is function call: " + r139);
        com.bytedance.ai.monitor.b.d("applet_switch_bot", new e0(r139));
        if (r146 == null) goto L123;
        RealData r151 = r146.getData();
        if (r151 == null) goto L123;
        final String r152 = r151.getAppletId();
        if (r152 == null) goto L123;
        com.bytedance.ai.utils.f.j("llmMsgReceived --> " + r139.f483819b + " to applet: " + r152);
        r150.i("applet_lifecycle", "<parseMessage><msgId-" + r139.f483819b + "><conversationId-" + r139.f483820c + "> runapplet  : " + r152);
        if (r143 == null) goto L122;
        com.bytedance.ai.utils.j.c r153 = r143.f37652l;
        if (r153 == null) goto L122;
        r153.a();
    L122:
        ClientToolRunner r154 = ClientToolRunner.f36788a;
        ?? r155 = new x(r152, r139, r140, r143, r146, r141);
        r154.getClass();
        ClientToolRunner.f(r152, r146, r141, r140, r155);
    L127:
        return Unit.INSTANCE;
    L123:
        String r156 = "llmData is broken " + r139;
        r150.e("AppletRuntimeManager", r156);
        r140.invoke(-1, r156, "");
        if (r143 == null) goto L127;
        r143.a(r156);
        goto L127
    L128:
        Result.Companion r157 = Result.Companion;     // Catch: Throwable -> L89
        Lazy r158 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Throwable -> L89
        Object r159 = Result.m9449constructorimpl((LLMData) com.bytedance.ai.applet.base.gson.e.a(r139.f483818a, LLMData.class));     // Catch: Throwable -> L89
    L92:
        if (Result.m9455isFailureimpl(r159) == false) goto L94;
        r159 = null;
    L94:
        LLMData r160 = (LLMData) r159;
        if (r160 == null) goto L105;
        r160.setMsgId(r139.f483819b);
        r160.setConversationID(r139.f483820c);
        r160.setRealJSONData(r139.f483818a);
        r160.setFromBotId(r139.f483821d);
        r160.setCreateTime(Long.valueOf(r139.f483822e));
        RealData r161 = r160.getData();
        if (r161 == null) goto L104;
        RealData r162 = r160.getData();
        if (r162 == null) goto L102;
        String r163 = r162.getPluginId();
        if (r163 == null) goto L102;
    L103:
        r161.setPluginId(r163);
    L102:
        r163 = r139.f483824g;
    L104:
        r160.setQuestionId(r139.f483823f);
        r160.setFeatureMap(r139.f483825h);
        r132 = r160;
    L105:
        r139.f483827j = r132;
    L89:
        th = move-exception;
        Result.Companion r164 = Result.Companion;
        r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L92
    L74:
        r138 = 0;
        goto L75
    L65:
        if (Intrinsics.areEqual(r124, "system_ui_understanding_plugin.system_get_uiu_context_tool") == true) goto L68;
        r136 = false;
    L51:
        r131 = false;
        goto L53
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function1 r165 = (Function1) r102.L$8;
        Long r166 = (Long) r102.L$7;
        String r167 = (String) r102.L$6;
        String r168 = (String) r102.L$5;
        Map r169 = (Map) r102.L$4;
        r123 = (String) r102.L$3;
        String r170 = (String) r102.L$2;
        String r171 = (String) r102.L$1;
        String r172 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r118 = r165;
        r100 = r168;
        r122 = r171;
        r119 = r166;
        r101 = r167;
        r120 = r172;
        r121 = r169;
        r124 = r170;
    L31:
        r125 = (String) r104;
        if (r125 != null) goto L40;
        MessageUtils r173 = MessageUtils.f192258a;
        r102.L$0 = r120;
        r102.L$1 = r122;
        r102.L$2 = r124;
        r102.L$3 = r123;
        r102.L$4 = r121;
        r102.L$5 = r100;
        r102.L$6 = r101;
        r102.L$7 = r119;
        r102.L$8 = r118;
        r102.label = 2;
        r104 = r173.d(r120, r102);
        if (r104 == r105) goto L142;
        r111 = r101;
        goto L37
    L142:
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        LruCache<Long, com.bytedance.ai.utils.j.a> r174 = com.bytedance.ai.utils.j.f37639a;
        com.bytedance.ai.utils.j.a r175 = com.bytedance.ai.utils.j.b(Boxing.boxLong(CastLongProtector.parseLong(r216)));
        if (r175 == null) goto L21;
        com.bytedance.ai.utils.j.c r176 = r175.f37650j;
        if (r176 == null) goto L21;
        r176.a();
    L21:
        com.bytedance.ai.monitor.b.d("app_action", new h(r100, r101));
        if (r211.length() != 0) goto L24;
        boolean r177 = true;
    L25:
        if (r177 == false) goto L39;
        LruCache<String, String> r178 = com.bytedance.applet.utils.j.f192292a;
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
        r125 = com.bytedance.applet.utils.j.f192292a.get(r101);
        if (r125 != null) goto L38;
        MessageUtils r179 = MessageUtils.f192258a;
        r120 = r210;
        r102.L$0 = r120;
        r122 = r212;
        r102.L$1 = r122;
        r124 = r213;
        r102.L$2 = r124;
        r123 = r214;
        r102.L$3 = r123;
        r121 = r215;
        r102.L$4 = r121;
        r102.L$5 = r100;
        r102.L$6 = r101;
        r119 = r218;
        r102.L$7 = r119;
        r118 = r219;
        r102.L$8 = r118;
        r102.label = 1;
        r104 = r179.e(r101, r102);
        if (r104 != r105) goto L31;
        return r105;
    L38:
        r120 = r210;
        r122 = r212;
        r124 = r213;
        r123 = r214;
        r121 = r215;
        r119 = r218;
        r118 = r219;
        goto L40
    L39:
        r120 = r210;
        r122 = r212;
        r124 = r213;
        r123 = r214;
        r121 = r215;
        r119 = r218;
        r118 = r219;
        r125 = r211;
        goto L40
    L24:
        r177 = false;
    L7:
        r102 = new BaseAppActionListener$processUIAction$1(r110, r310);
        goto L8
    }
}

package com.bytedance.android.live.room.share.jsbridge;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class UseReturnDataCallbackHandler extends LiveWebShareCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f100285c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SelectType f100286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.room.share.jsbridge.a f100287b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/share/jsbridge/UseReturnDataCallbackHandler$SelectType;", "", UserProfileEvent.POSITION_NONE, "IM_RELATION", "IM_USER_ING", "DIRECT", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SelectType extends Enum<SelectType> {
        public static final SelectType DIRECT = null;
        public static final SelectType IM_RELATION = null;
        public static final SelectType IM_USER_ING = null;
        public static final SelectType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SelectType[] f100288a = null;

        static {
            SelectType r100 = new SelectType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            SelectType r101 = new SelectType("IM_RELATION", 1);
            IM_RELATION = r101;
            SelectType r102 = new SelectType("IM_USER_ING", 2);
            IM_USER_ING = r102;
            SelectType r103 = new SelectType("DIRECT", 3);
            DIRECT = r103;
            f100288a = new SelectType[]{r100, r101, r102, r103};
        }

        public static SelectType valueOf(String r100) {
            return (SelectType) r27.a.a(SelectType.class, r100);
        }

        public static SelectType[] values() {
            return (SelectType[]) f100288a.clone();
        }

        public SelectType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UseReturnDataCallbackHandler f100289a;

        public b(UseReturnDataCallbackHandler r100) {
            this.f100289a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f100289a.f100286a != SelectType.NONE) goto L9;
            ALogger.d("UseReturnDataCallbackHandler", "actionFinishWithFailure user cancel dialog ");     // Catch: Throwable -> L6
            this.f100289a.a(null);     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
    public final void onPreShare() {
        this.f100286a = SelectType.IM_USER_ING;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
    public final void onDialogDismiss() {
        super.onDialogDismiss();
        ALogger.d("UseReturnDataCallbackHandler", " onDialogDismiss curSelectType:" + this.f100286a);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Boolean.valueOf(new Handler(Looper.getMainLooper()).postDelayed(new b(this), 200)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public UseReturnDataCallbackHandler(com.bytedance.android.live.room.share.jsbridge.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f100287b = r100;
        this.f100286a = SelectType.NONE;
    }

    public final void a(Throwable r100) {
        JSONObject r101 = new JSONObject();
        r101.put("code", 0);
        r101.put("button", "cancel");
        if (r100 == null) goto L5;
        r101.put("msg", r100.getMessage());
    L5:
        this.f100287b.a(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback, com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback
    public final void onChannelShare(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        ALogger.d("UseReturnDataCallbackHandler", " onChannelShare channel:" + r100);
        if (Intrinsics.areEqual(r100, "chat_merge") == false) goto L6;
        this.f100286a = SelectType.IM_RELATION;
        return;
    L6:
        if (CollectionsKt.listOf(new String[]{"weixin", "weixin_moments", "qzone", "qq", "more", "weibo", "qr_code", "generate_image"}).contains(r100) == false) goto L10;
        this.f100286a = SelectType.DIRECT;
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
    public final void onContactSelect(boolean r100) {
        super.onContactSelect(r100);
        if (r100 == true) goto L6;
        this.f100286a = SelectType.NONE;
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final void onFail(Throwable r100) {
        super.onFail(r100);
        StringBuilder r101 = new StringBuilder(" onFail message: ");
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getMessage();
    L6:
        r101.append(r103);
        ALogger.d("UseReturnDataCallbackHandler", r101.toString());
        StringBuilder r104 = new StringBuilder("actionFinishWithFailure  ");
        if (r100 == null) goto L9;
        r102 = r100.getMessage();
    L9:
        r104.append(r102);
        ALogger.d("UseReturnDataCallbackHandler", r104.toString());
        a(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(String r100, Map r101) {
        JSONObject r102 = new JSONObject();
        boolean r103 = true;
        r102.put("code", 1);
        r102.put("button", r100);
        List r104 = null;
        if (r101 == null) goto L5;
        List r105 = (List) r101.get("to_user_ids");
    L6:
        JSONArray r106 = new JSONArray();
        if (r105 == null) goto L12;
        Iterator r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.put((String) r107.next());
    L12:
        JSONObject r108 = new JSONObject();
        r108.put("uid", r106);
        Unit r109 = Unit.INSTANCE;
        r102.put("extra_info", r108);
        if (r101 == null) goto L19;
        List r110 = (List) r101.get("im_checked");
        if (r110 == null) goto L19;
        String r111 = (String) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L19;
        r102.put("im_checked", Intrinsics.areEqual(r111, "true"));
    L19:
        if (r101 == null) goto L25;
        List r112 = (List) r101.get("token_alert_checked");
        if (r112 == null) goto L25;
        String r113 = (String) CollectionsKt.firstOrNull(r112);
        if (r113 == null) goto L25;
        r102.put("token_alert_checked", Intrinsics.areEqual(r113, "true"));
    L25:
        com.bytedance.android.live.room.share.jsbridge.a r114 = this.f100287b;
        if (r101 == null) goto L28;
        List r115 = (List) r101.get("code");
    L29:
        List r116 = r115;
        if (r116 != null) goto L32;
    L35:
        boolean r117 = true;
    L36:
        if (r117 == true) goto L39;
        r102.put("code", CastIntegerProtector.parseInt((String) ListProtector.get(r115, 0)));
    L39:
        if (r101 == null) goto L41;
        r104 = (List) r101.get("qrcode_alert_platform");
    L41:
        List r118 = r104;
        if (r118 != null) goto L44;
    L47:
        if (r103 == true) goto L49;
        r102.put("qrcode_alert_platform", ListProtector.get(r104, 0));
    L49:
        r114.a(r102);
        return;
    L44:
        if (r118.isEmpty() == true) goto L47;
        r103 = false;
        goto L47
    L32:
        if (r116.isEmpty() == true) goto L35;
        r117 = false;
        goto L36
    L28:
        r115 = null;
        goto L29
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final void onSuccess(String r100, String r101) {
        super.onSuccess(r100, r101);
        ALogger.d("UseReturnDataCallbackHandler", " onSuccess platform:" + r100 + " shareType:" + r101);
        if ((!Intrinsics.areEqual(r100, "chat_merge")) == false) goto L6;
        b(r100, null);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallbackWithExtra
    public final void onSuccessWithExtra(String r100, String r101, Map<String, ? extends List<String>> r102) {
        super.onSuccessWithExtra(r100, r101, r102);
        b(r100, r102);
    }
}

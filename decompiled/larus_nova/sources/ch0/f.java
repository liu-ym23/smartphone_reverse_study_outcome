package ch0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {
    @Deprecated(message = "即将废弃，声波状态需要从单独的Observable中获取,LinkUserDataMergeCenterV2#linkUserTalkingObservable")
    public static final boolean a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isTalking");
        h r101 = r100.f23725b;
        if (r101 == null) goto L11;
        if (r101 == null) goto L11;
        if (r101.f23739g != 1) goto L11;
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.f23737e != true) goto L19;
    L16:
        return true;
    L19:
        return false;
    L11:
        j r102 = r100.f23726c;
        if (r102 == null) goto L20;
        if (r102 != null) goto L15;
        return false;
    L15:
        if (r102.f23745b == true) goto L16;
        return false;
    L20:
        return false;
    }

    public static final boolean b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVideoOrAvatar");
        if (d(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (c(r100) == false) goto L7;
        return true;
    }

    public static final boolean c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linkTypeIsVideoOrAvatar");
        ILinkPlayerInfoBridge r101 = r100.f23724a;
        if (r101 != null) goto L5;
    L6:
        ILinkPlayerInfoBridge r102 = r100.f23724a;
        if (r102 != null) goto L9;
    L11:
        return false;
    L9:
        if (r102.getLinkType() != 3) goto L11;
        return true;
    L5:
        if (r101.getLinkType() != 1) goto L6;
        return true;
    }

    public static final boolean d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mediaTypeIsVideoOrAvatar");
        h r101 = r100.f23725b;
        if (r101 == null) goto L11;
        if (r101 == null) goto L11;
        if (r101.f23739g != 1) goto L11;
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.f23735c == true) goto L27;
    L24:
        return true;
    L27:
        return false;
    L11:
        j r102 = r100.f23726c;
        if (r102 == null) goto L28;
        if (r102 == null) goto L15;
        Integer r103 = Integer.valueOf(r102.f23746c);
    L16:
        if (r103 != null) goto L19;
    L20:
        if (r103 != null) goto L23;
        return false;
    L23:
        if (r103.intValue() == 3) goto L24;
        return false;
    L19:
        if (r103.intValue() == 1) goto L24;
    L15:
        r103 = null;
        goto L16
    L28:
        return false;
    }

    public static final String e(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toPriorityInfoStr");
        StringBuilder r101 = new StringBuilder("{uid: ");
        IBaseUser r102 = r100.f23724a.getUser();
        Long r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getIdString();
    L6:
        r101.append(r104);
        r101.append(", nickName:");
        IBaseUser r105 = r100.f23724a.getUser();
        if (r105 == null) goto L9;
        String r106 = r105.getNickName();
    L10:
        r101.append(r106);
        r101.append(", isUnSilence: ");
        r101.append(n.i(r100.f23724a));
        r101.append(", isTalking: ");
        h r107 = r100.f23725b;
        if (r107 == null) goto L13;
        Boolean r108 = Boolean.valueOf(r107.f23737e);
    L14:
        r101.append(r108);
        r101.append(", lastTalkingTime: ");
        h r109 = r100.f23725b;
        if (r109 == null) goto L17;
        r103 = Long.valueOf(r109.f23738f);
    L17:
        r101.append(r103);
        r101.append(", joinChannelTime: ");
        r101.append(r100.f23724a.getJoinChannelTime());
        r101.append('}');
        return r101.toString();
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}

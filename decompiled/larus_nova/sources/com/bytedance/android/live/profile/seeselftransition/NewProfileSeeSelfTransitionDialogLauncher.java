package com.bytedance.android.live.profile.seeselftransition;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileDialogLauncher;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p004enum.ProfileMode;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class NewProfileSeeSelfTransitionDialogLauncher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f86142d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NewProfileDialogLauncher f86143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NewProfileDialogLauncher f86144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NewProfileTransitionDialogManager f86145c;

    public static final class a {
        @JvmStatic
        public static boolean a(UserProfileEvent r100) {
            if (r100 == null) goto L4;
            String r101 = r100.mSource;
        L6:
            return TextUtils.equals(r101, "50");
        L4:
            r101 = null;
            goto L6
        }
    }

    static {
    }

    public NewProfileSeeSelfTransitionDialogLauncher() {
    }

    public final void c() {
        if (this.f86145c != null) goto L6;
        NewProfileTransitionDialogManager r100 = new NewProfileTransitionDialogManager();
        NewProfileSeeSelfTransitionDialogLauncher$ensureTransitionDialogHolder$1$1 r101 = new NewProfileSeeSelfTransitionDialogLauncher$ensureTransitionDialogHolder$1$1(this);
        Intrinsics.checkNotNullParameter(r101, "action");
        r100.f86147a = r101;
        Unit r102 = Unit.INSTANCE;
        this.f86145c = r100;
        return;
    }

    public static final void b(NewProfileSeeSelfTransitionDialogLauncher r100, ProfileMode r101) {
        r100.getClass();
        ALogger.e("TransitionDialogLauncher", "request error: " + r101);
        r100.c();
        NewProfileTransitionDialogManager r102 = r100.f86145c;
        if (r102 == null) goto L6;
        r102.f();
        return;
    }

    public static final void a(NewProfileSeeSelfTransitionDialogLauncher r100, ProfileMode r101, b r102, FragmentManager r103) {
        r100.getClass();
        StringBuilder r104 = new StringBuilder("dialog created: ");
        if (r102 == null) goto L5;
        String r105 = r102.toString();
    L6:
        r104.append(r105);
        r104.append(", mode: ");
        r104.append(r101);
        ALogger.i("TransitionDialogLauncher", r104.toString());
        r100.c();
        if (r102 == null) goto L23;
        if (r103 == null) goto L23;
        int r106 = c.f86162a[r101.ordinal()];
        if (r106 != 1) goto L13;
        NewProfileTransitionDialogManager r107 = r100.f86145c;
        if (r107 == null) goto L31;
        r107.d(r102, r103);
        return;
    L31:
        return;
    L13:
        if (r106 == 2) goto L17;
        NewProfileTransitionDialogManager r108 = r100.f86145c;
        if (r108 == null) goto L27;
        r108.f();
        return;
    L27:
        return;
    L17:
        NewProfileTransitionDialogManager r109 = r100.f86145c;
        if (r109 == null) goto L29;
        r109.e(r102, r103);
        return;
    L29:
        return;
    L23:
        NewProfileTransitionDialogManager r110 = r100.f86145c;
        if (r110 == null) goto L33;
        r110.f();
        return;
    L33:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final Disposable d(ProfileMonitor r210, FragmentActivity r211, IRoom r212, DataCenter r213, boolean r214, IBaseUser r215, String r216, UserProfileEvent r217) {
        Intrinsics.checkNotNullParameter(r210, "profileMonitor");
        Intrinsics.checkNotNullParameter(r212, "room");
        Intrinsics.checkNotNullParameter(r217, "event");
        ALogger.i("TransitionDialogLauncher", "prepareTransitionDialogRequest");
        if (this.f86143a != null) goto L6;
        this.f86143a = new NewProfileDialogLauncher();
    L6:
        if (this.f86144b != null) goto L8;
        this.f86144b = new NewProfileDialogLauncher();
    L8:
        NewProfileDialogLauncher r100 = this.f86143a;
        if (r100 == null) goto L23;
        Disposable r101 = NewProfileDialogLauncher.g(r100, r210, r211, r212, r213, r214, r215, r216, r217, ProfileMode.USER_BEFORE, 1, new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$showToHideDisposable$1(this), new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$showToHideDisposable$2(this), 8192);
        if (r101 == null) goto L24;
        NewProfileDialogLauncher r102 = this.f86144b;
        if (r102 == null) goto L20;
        ProfileMonitor r103 = new ProfileMonitor(r210.f86097f);
        r103.f86093b.putAll(r210.f86093b);
        Disposable r104 = NewProfileDialogLauncher.g(r102, r103, r211, r212, r213, r214, r215, r216, r217, ProfileMode.USER_CURRENT, 2, new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$1(this), new NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$2(this), 8192);
        if (r104 == null) goto L20;
        c();
        return Disposables.fromAction(new d(r101, r104));
    L20:
        r101.dispose();
        return null;
    L24:
        return null;
    L23:
        return null;
    }
}

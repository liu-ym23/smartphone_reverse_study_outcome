package com.stepos.ailauncher.chat.sheet;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.activity.ChatScene;
import com.stepos.ailauncher.container.m0;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.sheet.SheetLaunchOptions;
import com.stepos.ailauncher.sheet.s0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/f;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "e", "(Landroid/content/Context;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "c", "(Landroid/content/Context;)Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "Lcom/stepos/ailauncher/chat/activity/ChatScene;", HomeGestureEligibilityContract.EXTRA_SCENE, Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/activity/ChatScene;)Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "f", "(Lcom/stepos/ailauncher/chat/activity/ChatScene;)Ljava/lang/String;", "Landroid/app/Activity;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/app/Activity;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.sheet.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2735f {
    public static final C2735f INSTANCE = new C2735f();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.sheet.f$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ChatScene.values().length];
            try {
                iArr[ChatScene.DESKTOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatScene.BOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChatScene.TRANSIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChatScene.LOCK_SCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ChatScene.HOME_OVERLAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ChatScene.HOME_RESIDENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HomeRootToken.values().length];
            try {
                iArr2[HomeRootToken.DESKTOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[HomeRootToken.BOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[HomeRootToken.MINUS_ONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[HomeRootToken.LOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final HomeRootToken b(ChatScene scene) {
        kotlin.jvm.internal.p.i(scene, "scene");
        switch (a.$EnumSwitchMapping$0[scene.ordinal()]) {
            case 1:
                return HomeRootToken.DESKTOP;
            case 2:
            case 3:
                return HomeRootToken.BOARD;
            case 4:
                return HomeRootToken.LOCK;
            case 5:
            case 6:
                return HomeRootToken.MINUS_ONE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final HomeRootToken c(Context context) {
        HomeRootToken homeRootTokenFromWire;
        kotlin.jvm.internal.p.i(context, "context");
        Activity activityA = a(context);
        Intent intent = activityA != null ? activityA.getIntent() : null;
        return (intent == null || !intent.hasExtra("com.stepos.ailauncher.sheet.extra.ROOT_TOKEN") || (homeRootTokenFromWire = HomeRootToken.INSTANCE.fromWire(intent.getStringExtra("com.stepos.ailauncher.sheet.extra.ROOT_TOKEN"))) == null) ? activityA instanceof ChatActivity ? b(ChatScene.INSTANCE.a(((ChatActivity) activityA).getIntent())) : g0.b(m0.INSTANCE.h(), s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).R()) ? HomeRootToken.MINUS_ONE : HomeRootToken.DESKTOP : homeRootTokenFromWire;
    }

    public final String d(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        String strE = e(context);
        SheetLaunchOptions.Companion companion = SheetLaunchOptions.INSTANCE;
        Activity activityA = a(context);
        return new SheetLaunchOptions(null, 0, false, strE, false, companion.a(activityA != null ? activityA.getIntent() : null).getVisualStackRoot(), 23, null).d();
    }

    public final String e(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return c(context).getWire();
    }

    public final String f(ChatScene scene) {
        kotlin.jvm.internal.p.i(scene, "scene");
        int i10 = a.$EnumSwitchMapping$1[b(scene).ordinal()];
        if (i10 == 1) {
            return "desktop";
        }
        if (i10 == 2) {
            return "board";
        }
        if (i10 == 3) {
            return com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE;
        }
        if (i10 == 4) {
            return "lock";
        }
        throw new NoWhenBranchMatchedException();
    }
}

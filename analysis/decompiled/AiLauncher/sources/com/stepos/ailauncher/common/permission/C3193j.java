package com.stepos.ailauncher.common.permission;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.m0;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0004\b'\u0010&J+\u0010+\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010!2\b\u0010)\u001a\u0004\u0018\u00010!2\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\f2\u0006\u0010$\u001a\u00020!H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/common/permission/j;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "c", "(Landroid/content/Context;)I", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;", "launchPolicy", "Lcom/stepos/ailauncher/common/permission/e;", "k", "(Landroid/content/Context;Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;)Lcom/stepos/ailauncher/common/permission/e;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;", "host", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/common/permission/e;)Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;", PolicySdkConstants.policyFileDir, "e", "(Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;)Lcom/stepos/ailauncher/common/permission/e;", "", "hasContextActivity", "overlayOpenAndForeground", "hasResumedRegisteredHost", "hostInHomeTask", "keyguardLocked", "foreignTaskId", "Lcom/stepos/ailauncher/common/permission/i;", Const.INTENT_KEY_PKGNAME, "(ZZZZZI)Lcom/stepos/ailauncher/common/permission/i;", "Landroid/app/Activity;", "m", "(Landroid/content/Context;)Landroid/app/Activity;", "activity", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/app/Activity;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "fromContext", "registered", "launcherTaskId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/app/Activity;Landroid/app/Activity;I)Z", "f", "(Landroid/app/Activity;)Lcom/stepos/ailauncher/common/permission/e;", "", "TAG", "Ljava/lang/String;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.permission.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3193j {
    public static final C3193j INSTANCE = new C3193j();
    private static final String TAG = "PermissionHostResolver";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.permission.j$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PermissionHostSource.values().length];
            try {
                iArr[PermissionHostSource.CONTEXT_ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionHostSource.REGISTERED_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PermissionHostSource.ANCHOR_FOREIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PermissionHostSource.INDEPENDENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ PermissionHost l(C3193j c3193j, Context context, PermissionLaunchPolicy permissionLaunchPolicy, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            permissionLaunchPolicy = PermissionLaunchPolicy.AUTO;
        }
        return c3193j.k(context, permissionLaunchPolicy);
    }

    public final PermissionLaunchPolicy a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return j(l(this, context, null, 2, null));
    }

    public final PermissionHostDecision b(boolean hasContextActivity, boolean overlayOpenAndForeground, boolean hasResumedRegisteredHost, boolean hostInHomeTask, boolean keyguardLocked, int foreignTaskId) {
        if (hasContextActivity && !hostInHomeTask) {
            return new PermissionHostDecision(PermissionLaunchKind.IN_HOST_TASK, PermissionUiScene.GENERIC_ACTIVITY, PermissionHostSource.CONTEXT_ACTIVITY);
        }
        if (hasContextActivity) {
            return new PermissionHostDecision(PermissionLaunchKind.NEW_TASK_ANCHORED, PermissionUiScene.GENERIC_ACTIVITY, PermissionHostSource.INDEPENDENT);
        }
        if (overlayOpenAndForeground) {
            return new PermissionHostDecision(PermissionLaunchKind.NEW_TASK_ANCHORED, PermissionUiScene.MINUS_ONE_OVERLAY, PermissionHostSource.INDEPENDENT);
        }
        if (hasResumedRegisteredHost && !hostInHomeTask) {
            return new PermissionHostDecision(PermissionLaunchKind.IN_HOST_TASK, PermissionUiScene.GENERIC_ACTIVITY, PermissionHostSource.REGISTERED_HOST);
        }
        if (hasResumedRegisteredHost) {
            return new PermissionHostDecision(PermissionLaunchKind.NEW_TASK_ANCHORED, PermissionUiScene.GENERIC_ACTIVITY, PermissionHostSource.INDEPENDENT);
        }
        if (!keyguardLocked && foreignTaskId > 0) {
            return new PermissionHostDecision(PermissionLaunchKind.NEW_TASK_ANCHORED, PermissionUiScene.EXPRESS_CAPSULE, PermissionHostSource.ANCHOR_FOREIGN);
        }
        return new PermissionHostDecision(PermissionLaunchKind.NEW_TASK_ANCHORED, PermissionUiScene.WAKE_NO_PANEL, PermissionHostSource.INDEPENDENT);
    }

    public final int c(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return K.INSTANCE.a(context);
    }

    public final int d(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return K.INSTANCE.c(context);
    }

    public final PermissionHost e(PermissionLaunchPolicy policy) {
        kotlin.jvm.internal.p.i(policy, "policy");
        if (policy == PermissionLaunchPolicy.INDEPENDENT_TASK) {
            return new PermissionHost(PermissionLaunchKind.NEW_TASK_ANCHORED, null, -1, PermissionUiScene.WAKE_NO_PANEL);
        }
        return null;
    }

    public final PermissionHost f(Activity activity) {
        return new PermissionHost(PermissionLaunchKind.IN_HOST_TASK, activity, activity.getTaskId(), PermissionUiScene.GENERIC_ACTIVITY);
    }

    public final boolean g(Activity fromContext, Activity registered, int launcherTaskId) {
        if (launcherTaskId <= 0) {
            return false;
        }
        if (i(fromContext)) {
            kotlin.jvm.internal.p.f(fromContext);
            if (fromContext.getTaskId() == launcherTaskId) {
                return true;
            }
        }
        if (h(registered)) {
            kotlin.jvm.internal.p.f(registered);
            if (registered.getTaskId() == launcherTaskId) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h(Activity activity) {
        Lifecycle lifecycle;
        Lifecycle.State state;
        if (!i(activity)) {
            return false;
        }
        LifecycleOwner lifecycleOwner = activity instanceof LifecycleOwner ? (LifecycleOwner) activity : null;
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null || (state = lifecycle.getState()) == null) {
            return false;
        }
        return state.isAtLeast(Lifecycle.State.RESUMED);
    }

    public final boolean i(Activity activity) {
        return (activity == null || (activity instanceof PermissionProxyActivity) || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public final PermissionLaunchPolicy j(PermissionHost host) {
        kotlin.jvm.internal.p.i(host, "host");
        return host.e() ? PermissionLaunchPolicy.INDEPENDENT_TASK : PermissionLaunchPolicy.AUTO;
    }

    public final PermissionHost k(Context context, PermissionLaunchPolicy launchPolicy) {
        PermissionHost permissionHostF;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(launchPolicy, "launchPolicy");
        PermissionHost permissionHostE = e(launchPolicy);
        if (permissionHostE != null) {
            Log.i(TAG, "resolve policy=" + launchPolicy + " source=INDEPENDENT anchor=-1");
            return permissionHostE;
        }
        Activity activityM = m(context);
        Activity activityH = C3191h.INSTANCE.h();
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
        boolean z10 = keyguardManager != null && keyguardManager.isKeyguardLocked();
        K k10 = K.INSTANCE;
        int iA = k10.a(context);
        boolean zG = g(activityM, activityH, k10.b(context));
        boolean zI = i(activityM);
        m0 m0Var = m0.INSTANCE;
        PermissionHostDecision permissionHostDecisionB = b(zI, m0Var.h() && m0Var.g(), h(activityH), zG, z10, iA);
        int i10 = a.$EnumSwitchMapping$0[permissionHostDecisionB.getSource().ordinal()];
        if (i10 == 1) {
            kotlin.jvm.internal.p.f(activityM);
            permissionHostF = f(activityM);
        } else if (i10 == 2) {
            kotlin.jvm.internal.p.f(activityH);
            permissionHostF = f(activityH);
        } else if (i10 == 3) {
            permissionHostF = new PermissionHost(PermissionLaunchKind.NEW_TASK_ANCHORED, null, iA, PermissionUiScene.EXPRESS_CAPSULE);
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            permissionHostF = new PermissionHost(PermissionLaunchKind.NEW_TASK_ANCHORED, null, -1, permissionHostDecisionB.getUiScene());
        }
        PermissionHostSource source = permissionHostDecisionB.getSource();
        PermissionLaunchKind kind = permissionHostF.getKind();
        PermissionUiScene uiScene = permissionHostF.getUiScene();
        int anchorTaskId = permissionHostF.getAnchorTaskId();
        String simpleName = activityM != null ? activityM.getClass().getSimpleName() : null;
        String simpleName2 = activityH != null ? activityH.getClass().getSimpleName() : null;
        Log.i(TAG, "resolve source=" + source + " kind=" + kind + " scene=" + uiScene + " anchor=" + anchorTaskId + " ctx=" + simpleName + " reg=" + simpleName2 + " overlay=" + m0Var.h() + "/" + m0Var.g() + " homeTask=" + zG + " keyguard=" + z10);
        return permissionHostF;
    }

    public final Activity m(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                if (!INSTANCE.i((Activity) context)) {
                    context = null;
                }
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}

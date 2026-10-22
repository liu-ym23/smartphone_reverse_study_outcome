package com.mdisdk;

import C7.r;
import D7.v;
import android.content.Intent;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.mdisdk.action.Action;
import com.mdisdk.action.CaptureAction;
import com.mdisdk.action.CaptureData;
import com.mdisdk.action.ClickAction;
import com.mdisdk.action.FlingAction;
import com.mdisdk.action.KeyEventAction;
import com.mdisdk.action.LongClickAction;
import com.mdisdk.action.MoveAppAction;
import com.mdisdk.action.OpenAppAction;
import com.mdisdk.action.ScaleAction;
import com.mdisdk.action.SetTextAction;
import com.mdisdk.action.SwipeAction;
import com.mdisdk.action.UiSnapshotAction;
import com.mdisdk.action.WaitAction;
import com.mdisdk.capability.model.IntentEntity;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.request.UiSnapshot;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007JK\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J[\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ[\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b \u0010\u001eJS\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b'\u0010(Jo\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010*\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b,\u0010-J3\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010/\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b0\u00101J7\u00107\u001a\b\u0012\u0004\u0012\u0002040\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b5\u00106Jg\u0010?\u001a\b\u0012\u0004\u0012\u00020<0\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b=\u0010>Js\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\bE\u0010FJS\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020\"2\u0006\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\bJ\u0010(JG\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u000e2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\bO\u0010PR$\u0010S\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050R8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u0007¨\u0006V"}, d2 = {"Lcom/mdisdk/TaskActionBuilder;", "", AppAgent.CONSTRUCT, "()V", "", "Lcom/mdisdk/action/Action;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ljava/util/List;", "", "packageName", "Landroid/content/Intent;", "targetActivity", "Lcom/mdisdk/capability/model/IntentEntity;", "entity", "", WindowStateInfo.KEY_DISPLAY_ID, "tag", "LC7/r;", "addOpenAppAction", "(Ljava/lang/String;Landroid/content/Intent;Lcom/mdisdk/capability/model/IntentEntity;Ljava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "openApp", "", "durationInMs", "addWaitAction", "(JLjava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "wait", "x", "y", "windowTitle", "addClickAction", "(IIJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/mdisdk/action/Action;", RequestInfo.FUNCTION_CLICK, "addLongClickAction", RequestInfo.FUNCTION_LONG_CLICK, "", "centerX", "centerY", "startDistance", "endDistance", "addScaleAction", "(FFFFJLjava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "scale", "content", "activityClassName", "addSetTextAction", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/Action;", RequestInfo.FUNCTION_SET_TEXT, "keyCode", "addKeyEventAction", "(ILjava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "keyEvent", "targetPackageName", "Lcom/mdisdk/action/CaptureData;", "addCaptureAction", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "capture", "activityClass", "timeoutInMillis", "", "screenshot", "Lcom/mdisdk/capability/request/UiSnapshot;", "addUiSnapshotAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "uiSnapshot", "startX", "startY", "endX", "endY", "steps", "addSwipeAction", "(FFFFJILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/mdisdk/action/Action;", RequestInfo.FUNCTION_SWIPE, "velocityX", "velocityY", "addFlingAction", "fling", "toDisplayId", "toTop", "androidUserId", "addMoveAppAction", "(Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "moveApp", "", "actions", "Ljava/util/List;", "getActions$mdisdk_release", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskActionBuilder {
    private final List<Action<?>> actions = new ArrayList();

    public static /* synthetic */ Action addCaptureAction$default(TaskActionBuilder taskActionBuilder, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        return taskActionBuilder.addCaptureAction(num, str, str2);
    }

    public static /* synthetic */ Action addClickAction$default(TaskActionBuilder taskActionBuilder, int i, int i6, long j5, Integer num, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            num = null;
        }
        if ((i10 & 16) != 0) {
            str = null;
        }
        if ((i10 & 32) != 0) {
            str2 = null;
        }
        if ((i10 & 64) != 0) {
            str3 = "";
        }
        return taskActionBuilder.addClickAction(i, i6, j5, num, str, str2, str3);
    }

    public static /* synthetic */ Action addKeyEventAction$default(TaskActionBuilder taskActionBuilder, int i, Integer num, String str, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            num = null;
        }
        if ((i6 & 4) != 0) {
            str = "";
        }
        return taskActionBuilder.addKeyEventAction(i, num, str);
    }

    public static /* synthetic */ Action addLongClickAction$default(TaskActionBuilder taskActionBuilder, int i, int i6, long j5, Integer num, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            num = null;
        }
        if ((i10 & 16) != 0) {
            str = null;
        }
        if ((i10 & 32) != 0) {
            str2 = null;
        }
        if ((i10 & 64) != 0) {
            str3 = "";
        }
        return taskActionBuilder.addLongClickAction(i, i6, j5, num, str, str2, str3);
    }

    public static /* synthetic */ Action addMoveAppAction$default(TaskActionBuilder taskActionBuilder, String str, int i, Boolean bool, Integer num, String str2, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            bool = null;
        }
        if ((i6 & 8) != 0) {
            num = null;
        }
        if ((i6 & 16) != 0) {
            str2 = "";
        }
        return taskActionBuilder.addMoveAppAction(str, i, bool, num, str2);
    }

    public static /* synthetic */ Action addOpenAppAction$default(TaskActionBuilder taskActionBuilder, String str, Intent intent, IntentEntity intentEntity, Integer num, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        if ((i & 4) != 0) {
            intentEntity = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            str2 = "";
        }
        return taskActionBuilder.addOpenAppAction(str, intent, intentEntity, num, str2);
    }

    public static /* synthetic */ Action addSetTextAction$default(TaskActionBuilder taskActionBuilder, String str, Integer num, Integer num2, String str2, String str3, String str4, Integer num3, String str5, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            str4 = null;
        }
        if ((i & 64) != 0) {
            num3 = null;
        }
        if ((i & 128) != 0) {
            str5 = "";
        }
        return taskActionBuilder.addSetTextAction(str, num, num2, str2, str3, str4, num3, str5);
    }

    public static /* synthetic */ Action addSwipeAction$default(TaskActionBuilder taskActionBuilder, float f, float f7, float f9, float f10, long j5, int i, Integer num, String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 64) != 0) {
            num = null;
        }
        if ((i6 & 128) != 0) {
            str = null;
        }
        if ((i6 & 256) != 0) {
            str2 = null;
        }
        if ((i6 & 512) != 0) {
            str3 = "";
        }
        return taskActionBuilder.addSwipeAction(f, f7, f9, f10, j5, i, num, str, str2, str3);
    }

    public static /* synthetic */ Action addUiSnapshotAction$default(TaskActionBuilder taskActionBuilder, String str, String str2, String str3, Integer num, Long l, Boolean bool, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            l = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        if ((i & 64) != 0) {
            str4 = "";
        }
        return taskActionBuilder.addUiSnapshotAction(str, str2, str3, num, l, bool, str4);
    }

    public static /* synthetic */ Action addWaitAction$default(TaskActionBuilder taskActionBuilder, long j5, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str = "";
        }
        return taskActionBuilder.addWaitAction(j5, num, str);
    }

    public final Action<CaptureData> addCaptureAction(Integer displayId, String targetPackageName, String tag) {
        k.f(tag, "tag");
        CaptureAction captureAction = new CaptureAction(displayId, targetPackageName, tag);
        this.actions.add(captureAction);
        return captureAction;
    }

    public final Action<r> addClickAction(int x10, int y, long durationInMs, Integer displayId, String packageName, String windowTitle, String tag) {
        k.f(tag, "tag");
        ClickAction clickAction = new ClickAction(x10, y, durationInMs, displayId, packageName, windowTitle, tag);
        this.actions.add(clickAction);
        return clickAction;
    }

    public final Action<r> addFlingAction(float startX, float startY, float velocityX, float velocityY, long durationInMs, Integer displayId, String tag) {
        k.f(tag, "tag");
        FlingAction flingAction = new FlingAction(startX, startY, velocityX, velocityY, durationInMs, displayId, tag);
        this.actions.add(flingAction);
        return flingAction;
    }

    public final Action<r> addKeyEventAction(int keyCode, Integer displayId, String tag) {
        k.f(tag, "tag");
        KeyEventAction keyEventAction = new KeyEventAction(keyCode, displayId, tag);
        this.actions.add(keyEventAction);
        return keyEventAction;
    }

    public final Action<r> addLongClickAction(int x10, int y, long durationInMs, Integer displayId, String packageName, String windowTitle, String tag) {
        k.f(tag, "tag");
        LongClickAction longClickAction = new LongClickAction(x10, y, durationInMs, displayId, packageName, windowTitle, tag);
        this.actions.add(longClickAction);
        return longClickAction;
    }

    public final Action<r> addMoveAppAction(String packageName, int toDisplayId, Boolean toTop, Integer androidUserId, String tag) {
        k.f(packageName, "packageName");
        k.f(tag, "tag");
        MoveAppAction moveAppAction = new MoveAppAction(packageName, toDisplayId, toTop, androidUserId, tag);
        this.actions.add(moveAppAction);
        return moveAppAction;
    }

    public final Action<r> addOpenAppAction(String packageName, Intent targetActivity, IntentEntity entity, Integer displayId, String tag) {
        k.f(packageName, "packageName");
        k.f(tag, "tag");
        OpenAppAction openAppAction = new OpenAppAction(packageName, targetActivity, entity, displayId, tag);
        this.actions.add(openAppAction);
        return openAppAction;
    }

    public final Action<r> addScaleAction(float centerX, float centerY, float startDistance, float endDistance, long durationInMs, Integer displayId, String tag) {
        k.f(tag, "tag");
        ScaleAction scaleAction = new ScaleAction(centerX, centerY, startDistance, endDistance, durationInMs, displayId, tag);
        this.actions.add(scaleAction);
        return scaleAction;
    }

    public final Action<r> addSetTextAction(String content, Integer x10, Integer y, String windowTitle, String activityClassName, String packageName, Integer displayId, String tag) {
        k.f(content, "content");
        k.f(tag, "tag");
        SetTextAction setTextAction = new SetTextAction(content, x10, y, windowTitle, activityClassName, packageName, displayId, tag);
        this.actions.add(setTextAction);
        return setTextAction;
    }

    public final Action<r> addSwipeAction(float startX, float startY, float endX, float endY, long durationInMs, int steps, Integer displayId, String packageName, String windowTitle, String tag) {
        k.f(tag, "tag");
        SwipeAction swipeAction = new SwipeAction(startX, startY, endX, endY, durationInMs, steps, displayId, packageName, windowTitle, tag);
        this.actions.add(swipeAction);
        return swipeAction;
    }

    public final Action<UiSnapshot> addUiSnapshotAction(String packageName, String activityClass, String windowTitle, Integer displayId, Long timeoutInMillis, Boolean screenshot, String tag) {
        k.f(tag, "tag");
        UiSnapshotAction uiSnapshotAction = new UiSnapshotAction(packageName, activityClass, windowTitle, displayId, timeoutInMillis, screenshot, tag);
        this.actions.add(uiSnapshotAction);
        return uiSnapshotAction;
    }

    public final Action<r> addWaitAction(long durationInMs, Integer displayId, String tag) {
        k.f(tag, "tag");
        WaitAction waitAction = new WaitAction(durationInMs, displayId, tag);
        this.actions.add(waitAction);
        return waitAction;
    }

    public final List<Action<?>> build() {
        return v.f1(this.actions);
    }

    public final List<Action<?>> getActions$mdisdk_release() {
        return this.actions;
    }
}

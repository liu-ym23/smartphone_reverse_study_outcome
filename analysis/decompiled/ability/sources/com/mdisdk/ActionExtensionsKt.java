package com.mdisdk;

import C7.r;
import W7.a;
import W7.c;
import android.graphics.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mdisdk.action.Action;
import com.mdisdk.action.KeyEventAction;
import com.mdisdk.capability.model.IntentEntity;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.random.Random$Default;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\b\u001aG\u0010\u0013\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001f\u001a\u00020\u001e*\u00020\u001d¢\u0006\u0004\b\u001f\u0010 \u001a\u0011\u0010!\u001a\u00020\u001d*\u00020\u001e¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/mdisdk/TaskActionBuilder;", "", WindowStateInfo.KEY_DISPLAY_ID, "", "tag", "Lcom/mdisdk/action/Action;", "LC7/r;", "addBackAction", "(Lcom/mdisdk/TaskActionBuilder;Ljava/lang/Integer;Ljava/lang/String;)Lcom/mdisdk/action/Action;", "back", "addHomeAction", "home", "Landroid/graphics/Rect;", "bound", "constraintBound", "", "durationInMs", "addClickRectAction", "(Lcom/mdisdk/TaskActionBuilder;Landroid/graphics/Rect;Landroid/graphics/Rect;JLjava/lang/Integer;Ljava/lang/String;)V", "clickRandom", "r1", "r2", "getIntersection", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Rect;", TypedValues.TransitionType.S_FROM, "until", "addWaitRandomAction", "(Lcom/mdisdk/TaskActionBuilder;JJLjava/lang/String;)V", "waitRandom", "Lcom/mdisdk/capability/model/IntentEntity;", "Lorg/json/JSONObject;", "toJson", "(Lcom/mdisdk/capability/model/IntentEntity;)Lorg/json/JSONObject;", "toIntentEntity", "(Lorg/json/JSONObject;)Lcom/mdisdk/capability/model/IntentEntity;", "mdisdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActionExtensionsKt {
    public static final Action<r> addBackAction(TaskActionBuilder taskActionBuilder, Integer num, String tag) {
        k.f(taskActionBuilder, "<this>");
        k.f(tag, "tag");
        KeyEventAction keyEventAction = new KeyEventAction(4, num, tag);
        taskActionBuilder.getActions$mdisdk_release().add(keyEventAction);
        return keyEventAction;
    }

    public static /* synthetic */ Action addBackAction$default(TaskActionBuilder taskActionBuilder, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        return addBackAction(taskActionBuilder, num, str);
    }

    public static final void addClickRectAction(TaskActionBuilder taskActionBuilder, Rect bound, Rect rect, long j5, Integer num, String tag) {
        k.f(taskActionBuilder, "<this>");
        k.f(bound, "bound");
        k.f(tag, "tag");
        if (rect != null) {
            Rect intersection = getIntersection(bound, rect);
            if (intersection.isEmpty()) {
                throw new IllegalArgumentException(("Bounds do not intersect: " + bound + " and " + rect).toString());
            }
            bound = intersection;
        }
        Random$Default random$Default = c.f1492a;
        int i = bound.left;
        int i6 = bound.right;
        random$Default.getClass();
        a aVar = c.b;
        TaskActionBuilder.addClickAction$default(taskActionBuilder, aVar.c(i, i6), aVar.c(bound.top, bound.bottom), j5, num, null, null, tag, 48, null);
    }

    public static /* synthetic */ void addClickRectAction$default(TaskActionBuilder taskActionBuilder, Rect rect, Rect rect2, long j5, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            rect2 = null;
        }
        if ((i & 4) != 0) {
            j5 = 0;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            str = "";
        }
        addClickRectAction(taskActionBuilder, rect, rect2, j5, num, str);
    }

    public static final Action<r> addHomeAction(TaskActionBuilder taskActionBuilder, Integer num, String tag) {
        k.f(taskActionBuilder, "<this>");
        k.f(tag, "tag");
        KeyEventAction keyEventAction = new KeyEventAction(3, num, tag);
        taskActionBuilder.getActions$mdisdk_release().add(keyEventAction);
        return keyEventAction;
    }

    public static /* synthetic */ Action addHomeAction$default(TaskActionBuilder taskActionBuilder, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        return addHomeAction(taskActionBuilder, num, str);
    }

    public static final void addWaitRandomAction(TaskActionBuilder taskActionBuilder, long j5, long j6, String tag) {
        k.f(taskActionBuilder, "<this>");
        k.f(tag, "tag");
        c.f1492a.getClass();
        taskActionBuilder.addWaitAction(c.b.e(j5, j6), null, tag);
    }

    public static /* synthetic */ void addWaitRandomAction$default(TaskActionBuilder taskActionBuilder, long j5, long j6, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        addWaitRandomAction(taskActionBuilder, j5, j6, str);
    }

    private static final Rect getIntersection(Rect rect, Rect rect2) {
        return new Rect(Math.max(rect.left, rect2.left), Math.max(rect.top, rect2.top), Math.min(rect.right, rect2.right), Math.min(rect.bottom, rect2.bottom));
    }

    public static final IntentEntity toIntentEntity(JSONObject jSONObject) {
        k.f(jSONObject, "<this>");
        String strOptString = jSONObject.optString("componentName", "");
        String strOptString2 = jSONObject.optString("packageName", "");
        String strOptString3 = jSONObject.optString("activityClassName", "");
        String strOptString4 = jSONObject.optString("intentAction");
        k.c(strOptString4);
        String str = strOptString4.length() > 0 ? strOptString4 : null;
        String strOptString5 = jSONObject.optString("intentDataUri");
        k.c(strOptString5);
        String str2 = strOptString5.length() > 0 ? strOptString5 : null;
        String strOptString6 = jSONObject.optString("intentType");
        k.c(strOptString6);
        String str3 = strOptString6.length() > 0 ? strOptString6 : null;
        String strOptString7 = jSONObject.optString("intentCategories");
        k.c(strOptString7);
        String str4 = strOptString7.length() > 0 ? strOptString7 : null;
        String strOptString8 = jSONObject.optString("intentFlags");
        k.c(strOptString8);
        String str5 = strOptString8.length() > 0 ? strOptString8 : null;
        String strOptString9 = jSONObject.optString("intentExtras");
        k.c(strOptString9);
        return new IntentEntity(strOptString, strOptString2, strOptString3, str, str2, str3, str4, str5, strOptString9.length() > 0 ? strOptString9 : null);
    }

    public static final JSONObject toJson(IntentEntity intentEntity) throws JSONException {
        k.f(intentEntity, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("componentName", intentEntity.getComponentName());
        jSONObject.put("packageName", intentEntity.getPackageName());
        jSONObject.put("activityClassName", intentEntity.getActivityClassName());
        jSONObject.put("intentAction", intentEntity.getIntentAction());
        jSONObject.put("intentDataUri", intentEntity.getIntentDataUri());
        jSONObject.put("intentType", intentEntity.getIntentType());
        jSONObject.put("intentCategories", intentEntity.getIntentCategories());
        jSONObject.put("intentFlags", intentEntity.getIntentFlags());
        jSONObject.put("intentExtras", intentEntity.getIntentExtras());
        return jSONObject;
    }
}

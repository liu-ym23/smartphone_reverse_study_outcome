package com.obric.memorydata.sdk.screencapture.rule;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScreenEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ScreenEventRule implements Parcelable {
    public static final a Companion = null;
    private static final String TAG = "ScreenEventRule";
    private static final Map<ScreenEvent.a, Class<? extends ScreenEventRule>> eventTypeClassMap = null;
    private static final Gson gson = null;
    private Map<String, ? extends List<String>> blackActivityPrefixes;
    private List<String> blackPackages;
    private List<String> targetPackages;

    /* JADX INFO: compiled from: ScreenEventRule.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final ScreenEventRule a(String r5) {
            o.e(r5, "json");
            String r4 = new JSONObject(r5).optString("eventType");
            o.a(r4);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            a(ScreenEventRule.TAG, "eventType is empty");
            return null;
        L10:
            ScreenEvent.a r6 = ScreenEvent.a.valueOf(r4);
            Class r7 = (Class) ZeusTransformUtils.preCheckCast(ScreenEventRule.access$getEventTypeClassMap$cp().get(r6), Class.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L15;
            a(ScreenEventRule.TAG, "eventTypeClass is null");
            return null;
        L15:
            return (ScreenEventRule) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r5, r7), ScreenEventRule.class, "com.obric.aiagent.plugin");
        L5:
            r0 = false;
            goto L7
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract ScreenEvent.a getEventType();

    public abstract boolean isMatch(ScreenEvent r1, Context r2);

    public ScreenEventRule() {
    }

    public static final /* synthetic */ Map access$getEventTypeClassMap$cp() {
        return eventTypeClassMap;
    }

    public static final /* synthetic */ Gson access$getGson$cp() {
        return gson;
    }

    public List<String> getTargetPackages() {
        return this.targetPackages;
    }

    public void setTargetPackages(List<String> r3) {
        this.targetPackages = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public List<String> getBlackPackages() {
        return this.blackPackages;
    }

    public void setBlackPackages(List<String> r3) {
        this.blackPackages = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public Map<String, List<String>> getBlackActivityPrefixes() {
        return this.blackActivityPrefixes;
    }

    public void setBlackActivityPrefixes(Map<String, ? extends List<String>> r3) {
        this.blackActivityPrefixes = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(toJson());
    }

    public final String toJson() {
        String r1 = new Gson().toJson(this);
        o.c(r1, "toJson(...)");
        return r1;
    }

    public static /* synthetic */ boolean isMatch$default(ScreenEventRule r2, ScreenEvent r3, Context r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        return r2.isMatch(r3, r7);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isMatch");
    }

    public static /* synthetic */ boolean isFilter$memoryDataSDK_obricRelease$default(ScreenEventRule r2, String r3, Context r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        return r2.isFilter$memoryDataSDK_obricRelease(r3, r7);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isFilter");
    }

    public final boolean isFilter$memoryDataSDK_obricRelease(String r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "pkg");
        if (getBlackPackages() == null) goto L8;
        List<String> r0 = getBlackPackages();
        o.a(r0);
        if (r0.contains(r6) == false) goto L8;
        return true;
    L8:
        if (getTargetPackages() == null) goto L13;
        List<String> r1 = getTargetPackages();
        o.a(r1);
        if (r1.contains(r6) == true) goto L13;
        return true;
    L13:
        if (getBlackActivityPrefixes() == null) goto L25;
        if (r8 == null) goto L25;
        Map<String, List<String>> r2 = getBlackActivityPrefixes();
        o.a(r2);
        List r9 = (List) ZeusTransformUtils.preCheckCast(r2.get(r6), List.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L25;
        String r5 = getCurrentForegroundActivityName(r8);
        if (r5 == null) goto L25;
        Iterator r10 = r9.iterator();
    L21:
        if (r10.hasNext() == false) goto L25;
        if (d.o.o.b(r5, (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L21;
        return true;
    L25:
        return false;
    }

    private final String getCurrentForegroundActivityName(Context r3) {
        Object r2 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("activity");
        o.a(r2, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r4 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r2, ActivityManager.class, "com.obric.aiagent.plugin")).getRunningTasks(1);
        o.a(r4);
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
        ComponentName r5 = ((ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r4.get(0), ActivityManager.RunningTaskInfo.class, "com.obric.aiagent.plugin")).topActivity;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getClassName();
    L8:
        return null;
    }

    static {
        Companion = new a(null);
        Gson r0 = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(ScreenEventRule.class, Type.class, "com.obric.aiagent.plugin"), new e()).create();
        o.a(r0);
        gson = r0;
        eventTypeClassMap = ao.b(new m[]{s.a(ScreenEvent.a.f33862a, ScreenTouchEventRule.class), s.a(ScreenEvent.a.f33863b, InputMethodEventRule.class), s.a(ScreenEvent.a.f33864c, AppStateEventRule.class), s.a(ScreenEvent.a.f33865d, AppAccessibilityEventRule.class)});
    }
}

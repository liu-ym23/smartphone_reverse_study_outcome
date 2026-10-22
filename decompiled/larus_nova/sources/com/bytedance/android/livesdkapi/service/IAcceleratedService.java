package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.summer.AcceleratedService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000bH&J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&JB\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000bH&Jo\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000b2+\u0010\u0010\u001a'\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u0002H\u0004`\u0016H&J@\u0010\u0017\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000bH&JH\u0010\u0017\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000bH&J,\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J:\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000bH&Jg\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000b2+\u0010\u0010\u001a'\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u0002H\u0004`\u0016H&J2\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\u000bH&J\u0012\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J#\u0010 \u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H&¢\u0006\u0002\u0010$J9\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H!0\nj\b\u0012\u0004\u0012\u0002H!`\u000bH&¢\u0006\u0002\u0010%J+\u0010 \u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!2\u0006\u0010&\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H&¢\u0006\u0002\u0010'JB\u0010 \u001a\u00020(\"\b\b\u0000\u0010!*\u00020(2\u0006\u0010&\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u000f\u001a\u00020\u0003H&JA\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\u0006\u0010&\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H!0\nj\b\u0012\u0004\u0012\u0002H!`\u000bH&¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020-H&J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020-H&J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020-H&J\u0010\u00100\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020-H&J\u0010\u00101\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020-H&J\u0010\u00102\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020-H&J\u0010\u00103\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0003H&J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0003H&¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IAcceleratedService;", "Lcom/bytedance/android/live/base/IService;", "attachTask", "", "R", "registry", "Lcom/bytedance/android/livesdkapi/service/LiveLifecycle;", SocialConstants.PARAM_APP_DESC, "", "action", "Lkotlin/Function0;", "Lcom/bytedance/android/livesdkapi/service/OnAction;", "capacity", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "xml", "recovery", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "r", "", "Lcom/bytedance/android/livesdkapi/service/OnRecovery;", "attachToHost", "summerId", "type", "priority", "attachToRoom", "getGlobalLiveLifecycle", "Lcom/bytedance/android/livesdkapi/service/GlobalLiveLifecycle;", "scope", "getLiveTheme", "lookup", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "key", "(ILjava/lang/Class;)Ljava/lang/Object;", "Landroid/view/View;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "(ILjava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "onEnter", "Lcom/bytedance/android/livesdkapi/service/ILiveLifecycle;", d.f25928r, "onInLive", "onLaunch", "onPreload", "onShutdown", "release", "setLiveTheme", "theme", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAcceleratedService extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ int attachToRoom$default(IAcceleratedService r100, String r101, Function0 r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.attachToRoom(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToRoom");
        }

        public static /* synthetic */ int attachTask$default(IAcceleratedService r100, LiveLifecycle r101, String r102, Function0 r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.attachTask(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachTask");
        }

        public static /* synthetic */ int attachToRoom$default(IAcceleratedService r100, int r101, String r102, Function0 r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.attachToRoom(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToRoom");
        }

        public static /* synthetic */ int attachTask$default(IAcceleratedService r100, int r101, LiveLifecycle r102, String r103, Function0 r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.attachTask(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachTask");
        }

        public static /* synthetic */ int attachToRoom$default(IAcceleratedService r100, int r101, Context r102, int r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = null;
        L7:
            return r100.attachToRoom(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToRoom");
        }

        public static /* synthetic */ int attachToRoom$default(IAcceleratedService r100, int r101, String r102, Function0 r103, Function1 r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.attachToRoom(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToRoom");
        }

        public static /* synthetic */ int attachTask$default(IAcceleratedService r100, int r101, LiveLifecycle r102, Context r103, int r110, String r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 16) == 0) goto L7;
            r111 = null;
        L7:
            return r100.attachTask(r101, r102, r103, r110, r111);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachTask");
        }

        public static /* synthetic */ int attachTask$default(IAcceleratedService r100, int r101, LiveLifecycle r102, String r103, Function0 r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.attachTask(r101, r102, r103, r110, r111);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachTask");
        }
    }

    int attachTask(int r100, LiveLifecycle r101, Context r102, int r103, String r104);

    <R> int attachTask(int r100, LiveLifecycle r101, String r102, Function0<? extends R> r103);

    <R> int attachTask(int r100, LiveLifecycle r101, String r102, Function0<? extends R> r103, Function1<? super R, Unit> r104);

    <R> int attachTask(LiveLifecycle r100, String r101, Function0<? extends R> r102);

    <R> int attachToHost(@ISummerService.TaskID int r100, int r101, int r102, int r103, Function0<? extends R> r104);

    <R> int attachToHost(@ISummerService.TaskID int r100, int r101, int r102, Function0<? extends R> r103);

    int attachToRoom(int r100, Context r101, int r102, String r103);

    <R> int attachToRoom(int r100, String r101, Function0<? extends R> r102);

    <R> int attachToRoom(int r100, String r101, Function0<? extends R> r102, Function1<? super R, Unit> r103);

    <R> int attachToRoom(String r100, Function0<? extends R> r101);

    GlobalLiveLifecycle getGlobalLiveLifecycle(int r100);

    int getLiveTheme();

    <T extends View> View lookup(int r100, Class<T> r101, Context r102, ViewGroup r103, int r104);

    <T> T lookup(int r100, Class<T> r101);

    <T> T lookup(int r100, Class<T> r101, Function0<? extends T> r102);

    <T> T lookup(Class<T> r100);

    <T> T lookup(Class<T> r100, Function0<? extends T> r101);

    void onEnter(ILiveLifecycle r100);

    void onExit(ILiveLifecycle r100);

    void onInLive(ILiveLifecycle r100);

    void onLaunch(ILiveLifecycle r100);

    void onPreload(ILiveLifecycle r100);

    void onShutdown(ILiveLifecycle r100);

    void release(int r100);

    void setLiveTheme(int r100);
}

package com.mdisdk.capability;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.framework.FrameworkBridgeFactory;
import com.mdisdk.capability.model.ActionExtra;
import com.mdisdk.capability.model.Rect;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.ViewNode;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.utils.LockFreeSnowflakeGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.sync.a;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 S2\u00020\u0001:\u0001SB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005Jn\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014Jf\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJf\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u001d\u0010\u001cJv\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u001d\u0010!J\u0086\u0001\u0010%\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b%\u0010&J\u0086\u0001\u0010'\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b'\u0010&J>\u0010(\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b(\u0010)JH\u0010+\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b+\u0010,J>\u0010-\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b-\u0010)JB\u0010.\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b.\u0010)JB\u0010/\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b/\u0010)JB\u00100\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b0\u0010)JB\u00101\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b1\u0010)JX\u00106\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b6\u00107J,\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00108\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b9\u0010:J|\u0010@\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010\b2\b\u0010=\u001a\u0004\u0018\u00010\b2\b\u0010>\u001a\u0004\u0018\u00010\b2\b\u0010?\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b@\u0010AJ(\u0010E\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\bE\u0010FJ\"\u0010H\u001a\u00020G2\u0006\u0010C\u001a\u00020B2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010N\u001a\n M*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006T"}, d2 = {"Lcom/mdisdk/capability/UiCapabilityManager;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "", WindowStateInfo.KEY_DISPLAY_ID, "", "packageName", "windowTitle", "windowTitleContains", "activityClassName", "activityClassNameContains", "", "takeScreenshot", "", "timeoutMillis", "Lcom/mdisdk/capability/request/UiSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLH7/c;)Ljava/lang/Object;", "content", "x", "y", "targetPackageName", "targetWindowTitle", "targetActivityClass", RequestInfo.FUNCTION_SET_TEXT, "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "setTextWithTags", "tagDelayMillis", "Lcom/mdisdk/capability/TagWriteMode;", "tagWriteMode", "(ILjava/lang/String;JLcom/mdisdk/capability/TagWriteMode;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "start", "end", "targetNodeId", RequestInfo.FUNCTION_REPLACE_TEXT, "(ILjava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLH7/c;)Ljava/lang/Object;", RequestInfo.FUNCTION_REPLACE_TEXT_BY_CODE_POINT, RequestInfo.FUNCTION_CLICK, "(IIILjava/lang/String;JLH7/c;)Ljava/lang/Object;", TypedValues.TransitionType.S_DURATION, RequestInfo.FUNCTION_LONG_CLICK, "(IIIJLjava/lang/String;JLH7/c;)Ljava/lang/Object;", RequestInfo.FUNCTION_DOUBLE_CLICK, RequestInfo.FUNCTION_SCROLL_UP, RequestInfo.FUNCTION_SCROLL_DOWN, RequestInfo.FUNCTION_SCROLL_LEFT, RequestInfo.FUNCTION_SCROLL_RIGHT, "fromX", "fromY", "toX", "toY", RequestInfo.FUNCTION_SWIPE, "(IIIIIJLjava/lang/String;JLH7/c;)Ljava/lang/Object;", "requestId", "saveScreenshot", "(ILjava/lang/String;JLH7/c;)Ljava/lang/Object;", "function", "pkg", "window", "activity", "nodeId", "replaceTextInternal", "(Ljava/lang/String;ILjava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLH7/c;)Ljava/lang/Object;", "Lcom/mdisdk/capability/model/RequestInfo;", "info", "actionName", "executeAction", "(Lcom/mdisdk/capability/model/RequestInfo;Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "Lcom/mdisdk/capability/request/ApexResult;", "sendRequest", "(Lcom/mdisdk/capability/model/RequestInfo;JLH7/c;)Ljava/lang/Object;", "Lcom/mdisdk/capability/utils/LockFreeSnowflakeGenerator;", "idGenerator", "Lcom/mdisdk/capability/utils/LockFreeSnowflakeGenerator;", "kotlin.jvm.PlatformType", "applicationContext", "Landroid/content/Context;", "Lw9/a;", "tagTextWriteMutex", "Lw9/a;", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UiCapabilityManager {
    private static final String TAG = "UiCapabilityManager";
    private final Context applicationContext;
    private final LockFreeSnowflakeGenerator idGenerator;
    private final InterfaceC2108a tagTextWriteMutex;

    @c(c = "com.mdisdk.capability.UiCapabilityManager", f = "UiCapabilityManager.kt", l = {559}, m = "executeAction")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.capability.UiCapabilityManager$executeAction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiCapabilityManager.this.executeAction(null, null, 0L, this);
        }
    }

    @c(c = "com.mdisdk.capability.UiCapabilityManager$saveScreenshot$2", f = "UiCapabilityManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.mdisdk.capability.UiCapabilityManager$saveScreenshot$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ int $displayId;
        final /* synthetic */ String $packageName;
        final /* synthetic */ long $requestId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, String str, long j5, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$displayId = i;
            this.$packageName = str;
            this.$requestId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$displayId, this.$packageName, this.$requestId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            String str;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                Bitmap bitmapTakeScreenShot = FrameworkBridgeFactory.get().takeScreenShot(this.$displayId, this.$packageName);
                if (bitmapTakeScreenShot == null) {
                    Log.w(UiCapabilityManager.TAG, "takeScreenShot returned null for displayId=" + this.$displayId);
                    return null;
                }
                String str2 = this.$packageName;
                if (str2 == null || str2.length() == 0) {
                    str = "apex/screenshots";
                } else {
                    str = "apex/screenshots/" + this.$packageName;
                }
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, this.$requestId + ".png");
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    bitmapTakeScreenShot.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    bitmapTakeScreenShot.recycle();
                    Log.d(UiCapabilityManager.TAG, "Screenshot saved: " + file2.getAbsolutePath());
                    return file2.getAbsolutePath();
                } finally {
                }
            } catch (Exception e) {
                Log.e(UiCapabilityManager.TAG, "Failed to save screenshot", e);
                return null;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super String> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.mdisdk.capability.UiCapabilityManager", f = "UiCapabilityManager.kt", l = {597}, m = "sendRequest")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.capability.UiCapabilityManager$sendRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10191 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C10191(H7.c<? super C10191> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiCapabilityManager.this.sendRequest(null, 0L, this);
        }
    }

    @c(c = "com.mdisdk.capability.UiCapabilityManager", f = "UiCapabilityManager.kt", l = {614, 244, 246, 265, 269}, m = "setTextWithTags")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.capability.UiCapabilityManager$setTextWithTags$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10202 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C10202(H7.c<? super C10202> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiCapabilityManager.this.setTextWithTags(0, null, 0L, null, null, null, null, null, null, 0L, this);
        }
    }

    @c(c = "com.mdisdk.capability.UiCapabilityManager", f = "UiCapabilityManager.kt", l = {99, LocationRequestCompat.QUALITY_LOW_POWER}, m = RequestInfo.FUNCTION_SNAPSHOT)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.capability.UiCapabilityManager$snapshot$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10211 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10211(H7.c<? super C10211> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UiCapabilityManager.this.snapshot(null, null, null, null, null, null, false, 0L, this);
        }
    }

    public UiCapabilityManager(Context context) {
        k.f(context, "context");
        this.idGenerator = new LockFreeSnowflakeGenerator(0L, 0L, 3, null);
        this.applicationContext = context.getApplicationContext();
        this.tagTextWriteMutex = new a();
    }

    public static /* synthetic */ Object click$default(UiCapabilityManager uiCapabilityManager, int i, int i6, int i10, String str, long j5, H7.c cVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.click(i, i6, i10, str2, j5, cVar);
    }

    public static /* synthetic */ Object doubleClick$default(UiCapabilityManager uiCapabilityManager, int i, int i6, int i10, String str, long j5, H7.c cVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.doubleClick(i, i6, i10, str2, j5, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeAction(com.mdisdk.capability.model.RequestInfo r5, java.lang.String r6, long r7, H7.c<? super java.lang.Boolean> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.mdisdk.capability.UiCapabilityManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.mdisdk.capability.UiCapabilityManager$executeAction$1 r0 = (com.mdisdk.capability.UiCapabilityManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mdisdk.capability.UiCapabilityManager$executeAction$1 r0 = new com.mdisdk.capability.UiCapabilityManager$executeAction$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r4 = r0.L$0
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r9)
            goto L42
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.b.b(r9)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r9 = r4.sendRequest(r5, r7, r0)
            if (r9 != r1) goto L42
            return r1
        L42:
            com.mdisdk.capability.request.ApexResult r9 = (com.mdisdk.capability.request.ApexResult) r9
            boolean r4 = r9 instanceof com.mdisdk.capability.request.ApexResult.Success.Action
            java.lang.String r5 = "UiCapabilityManager"
            if (r4 == 0) goto L61
            java.lang.String r4 = " completed: "
            java.lang.StringBuilder r4 = androidx.appfunctions.metadata.a.x(r6, r4)
            com.mdisdk.capability.request.ApexResult$Success$Action r9 = (com.mdisdk.capability.request.ApexResult.Success.Action) r9
            java.lang.String r6 = r9.getMessage()
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r5, r4)
            goto Lba
        L61:
            boolean r4 = r9 instanceof com.mdisdk.capability.request.ApexResult.Error
            r3 = 0
            if (r4 == 0) goto L81
            java.lang.String r4 = " failed: "
            java.lang.StringBuilder r4 = androidx.appfunctions.metadata.a.x(r6, r4)
            com.mdisdk.capability.request.ApexResult$Error r9 = (com.mdisdk.capability.request.ApexResult.Error) r9
            java.lang.String r6 = r9.getMessage()
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.Throwable r6 = r9.getCause()
            android.util.Log.e(r5, r4, r6)
            goto Lba
        L81:
            boolean r4 = r9 instanceof com.mdisdk.capability.request.ApexResult.Timeout
            if (r4 == 0) goto La1
            java.lang.String r4 = " timeout after "
            java.lang.StringBuilder r4 = androidx.appfunctions.metadata.a.x(r6, r4)
            com.mdisdk.capability.request.ApexResult$Timeout r9 = (com.mdisdk.capability.request.ApexResult.Timeout) r9
            long r6 = r9.getTimeoutMs()
            r4.append(r6)
            java.lang.String r6 = " ms"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.w(r5, r4)
            goto Lba
        La1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "Unexpected result type for "
            r4.<init>(r7)
            r4.append(r6)
            java.lang.String r6 = ": "
            r4.append(r6)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            android.util.Log.w(r5, r4)
        Lba:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.UiCapabilityManager.executeAction(com.mdisdk.capability.model.RequestInfo, java.lang.String, long, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object replaceTextInternal(String str, int i, String str2, int i6, int i10, Integer num, Integer num2, String str3, String str4, String str5, Long l, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(str).displayId(new Integer(i)).packageName(str3).windowTitle(str4).activityClassName(str5).actionExtra(ActionExtra.replaceText(num != null ? num.intValue() : 0, num2 != null ? num2.intValue() : 0, i6, i10, str2, l != null ? l.longValue() : 0L)).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, str, j5, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveScreenshot(int i, String str, long j5, H7.c<? super String> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(i, str, j5, null), cVar);
    }

    public static /* synthetic */ Object scrollDown$default(UiCapabilityManager uiCapabilityManager, int i, int i6, int i10, String str, long j5, H7.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            str = null;
        }
        if ((i11 & 16) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.scrollDown(i, i6, i10, str, j5, cVar);
    }

    public static /* synthetic */ Object scrollLeft$default(UiCapabilityManager uiCapabilityManager, int i, int i6, int i10, String str, long j5, H7.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            str = null;
        }
        if ((i11 & 16) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.scrollLeft(i, i6, i10, str, j5, cVar);
    }

    public static /* synthetic */ Object scrollRight$default(UiCapabilityManager uiCapabilityManager, int i, int i6, int i10, String str, long j5, H7.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            str = null;
        }
        if ((i11 & 16) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.scrollRight(i, i6, i10, str, j5, cVar);
    }

    public static /* synthetic */ Object scrollUp$default(UiCapabilityManager uiCapabilityManager, int i, int i6, int i10, String str, long j5, H7.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            str = null;
        }
        if ((i11 & 16) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.scrollUp(i, i6, i10, str, j5, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendRequest(com.mdisdk.capability.model.RequestInfo r6, long r7, H7.c<? super com.mdisdk.capability.request.ApexResult> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.mdisdk.capability.UiCapabilityManager.C10191
            if (r0 == 0) goto L13
            r0 = r9
            com.mdisdk.capability.UiCapabilityManager$sendRequest$1 r0 = (com.mdisdk.capability.UiCapabilityManager.C10191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mdisdk.capability.UiCapabilityManager$sendRequest$1 r0 = new com.mdisdk.capability.UiCapabilityManager$sendRequest$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            java.lang.String r3 = "UiCapabilityManager"
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L29
            goto L6d
        L29:
            r5 = move-exception
            goto L70
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.b.b(r9)
            boolean r9 = r6.isValid()
            if (r9 != 0) goto L58
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Invalid request info: "
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.w(r3, r5)
            com.mdisdk.capability.request.ApexResult$Companion r5 = com.mdisdk.capability.request.ApexResult.INSTANCE
            java.lang.String r6 = "Invalid request info"
            r7 = 2
            r8 = 0
            com.mdisdk.capability.request.ApexResult$Error r5 = com.mdisdk.capability.request.ApexResult.Companion.error$default(r5, r6, r8, r7, r8)
            return r5
        L58:
            com.mdisdk.capability.request.ApexRequest r9 = new com.mdisdk.capability.request.ApexRequest
            android.content.Context r5 = r5.applicationContext
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.k.e(r5, r2)
            r9.<init>(r5)
            r0.label = r4     // Catch: java.lang.Exception -> L29
            java.lang.Object r9 = r9.request(r6, r7, r0)     // Catch: java.lang.Exception -> L29
            if (r9 != r1) goto L6d
            return r1
        L6d:
            com.mdisdk.capability.request.ApexResult r9 = (com.mdisdk.capability.request.ApexResult) r9     // Catch: java.lang.Exception -> L29
            return r9
        L70:
            java.lang.String r6 = "Error sending request"
            android.util.Log.e(r3, r6, r5)
            com.mdisdk.capability.request.ApexResult$Companion r6 = com.mdisdk.capability.request.ApexResult.INSTANCE
            java.lang.String r7 = "Request execution failed"
            com.mdisdk.capability.request.ApexResult$Error r5 = r6.error(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.UiCapabilityManager.sendRequest(com.mdisdk.capability.model.RequestInfo, long, H7.c):java.lang.Object");
    }

    public static /* synthetic */ Object sendRequest$default(UiCapabilityManager uiCapabilityManager, RequestInfo requestInfo, long j5, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.sendRequest(requestInfo, j5, cVar);
    }

    public static /* synthetic */ Object setText$default(UiCapabilityManager uiCapabilityManager, int i, String str, Integer num, Integer num2, String str2, String str3, String str4, long j5, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            num = null;
        }
        if ((i6 & 8) != 0) {
            num2 = null;
        }
        if ((i6 & 16) != 0) {
            str2 = null;
        }
        if ((i6 & 32) != 0) {
            str3 = null;
        }
        if ((i6 & 64) != 0) {
            str4 = null;
        }
        if ((i6 & 128) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.setText(i, str, num, num2, str2, str3, str4, j5, cVar);
    }

    public static /* synthetic */ Object setTextWithTags$default(UiCapabilityManager uiCapabilityManager, int i, String str, Integer num, Integer num2, String str2, String str3, String str4, long j5, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            num = null;
        }
        if ((i6 & 8) != 0) {
            num2 = null;
        }
        if ((i6 & 16) != 0) {
            str2 = null;
        }
        if ((i6 & 32) != 0) {
            str3 = null;
        }
        if ((i6 & 64) != 0) {
            str4 = null;
        }
        if ((i6 & 128) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.setTextWithTags(i, str, num, num2, str2, str3, str4, j5, cVar);
    }

    private static final void setTextWithTags$lambda$5$collect(Integer num, Integer num2, List<ViewNode> list, ViewNode viewNode) {
        if (viewNode.isVisible()) {
            Rect bounds = viewNode.getBounds();
            k.e(bounds, "getBounds(...)");
            if (((num == null || num2 == null || num.intValue() <= 0 || num2.intValue() <= 0) ? viewNode.isFocused() : num.intValue() >= bounds.getLeft() && num.intValue() < bounds.getRight() && num2.intValue() >= bounds.getTop() && num2.intValue() < bounds.getBottom()) && viewNode.isTextEditor() && viewNode.isEnabled() && viewNode.getText() != null && viewNode.getNodeId() != 0) {
                long nodeId = viewNode.getNodeId();
                if (SieveCacheKt.NodeMetaAndPreviousMask <= nodeId && nodeId < 2147483648L) {
                    list.add(viewNode);
                }
            }
            List<ViewNode> children = viewNode.getChildren();
            k.e(children, "getChildren(...)");
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                setTextWithTags$lambda$5$collect(num, num2, list, (ViewNode) it.next());
            }
        }
    }

    public static /* synthetic */ Object snapshot$default(UiCapabilityManager uiCapabilityManager, Integer num, String str, String str2, String str3, String str4, String str5, boolean z10, long j5, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        if ((i & 32) != 0) {
            str5 = null;
        }
        if ((i & 64) != 0) {
            z10 = false;
        }
        if ((i & 128) != 0) {
            j5 = 3000;
        }
        return uiCapabilityManager.snapshot(num, str, str2, str3, str4, str5, z10, j5, cVar);
    }

    public final Object click(int i, int i6, int i10, String str, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_CLICK).displayId(new Integer(i)).packageName(str).actionExtra(ActionExtra.click(i6, i10)).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_CLICK, j5, cVar);
    }

    public final Object doubleClick(int i, int i6, int i10, String str, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_DOUBLE_CLICK).displayId(new Integer(i)).packageName(str).actionExtra(ActionExtra.doubleClick(i6, i10)).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_DOUBLE_CLICK, j5, cVar);
    }

    public final Object longClick(int i, int i6, int i10, long j5, String str, long j6, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_LONG_CLICK).displayId(new Integer(i)).packageName(str).actionExtra(ActionExtra.longClick(i6, i10, j5)).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_LONG_CLICK, j6, cVar);
    }

    public final Object replaceText(int i, String str, int i6, int i10, Integer num, Integer num2, String str2, String str3, String str4, Long l, long j5, H7.c<? super Boolean> cVar) {
        return replaceTextInternal(RequestInfo.FUNCTION_REPLACE_TEXT, i, str, i6, i10, num, num2, str2, str3, str4, l, j5, cVar);
    }

    public final Object replaceTextByCodePoint(int i, String str, int i6, int i10, Integer num, Integer num2, String str2, String str3, String str4, Long l, long j5, H7.c<? super Boolean> cVar) {
        return replaceTextInternal(RequestInfo.FUNCTION_REPLACE_TEXT_BY_CODE_POINT, i, str, i6, i10, num, num2, str2, str3, str4, l, j5, cVar);
    }

    public final Object scrollDown(int i, int i6, int i10, String str, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_SCROLL_DOWN).displayId(new Integer(i)).packageName(str).actionExtra((i6 > 0 || i10 > 0) ? new ActionExtra(i6, i10) : null).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_SCROLL_DOWN, j5, cVar);
    }

    public final Object scrollLeft(int i, int i6, int i10, String str, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_SCROLL_LEFT).displayId(new Integer(i)).packageName(str).actionExtra((i6 > 0 || i10 > 0) ? new ActionExtra(i6, i10) : null).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_SCROLL_LEFT, j5, cVar);
    }

    public final Object scrollRight(int i, int i6, int i10, String str, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_SCROLL_RIGHT).displayId(new Integer(i)).packageName(str).actionExtra((i6 > 0 || i10 > 0) ? new ActionExtra(i6, i10) : null).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_SCROLL_RIGHT, j5, cVar);
    }

    public final Object scrollUp(int i, int i6, int i10, String str, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_SCROLL_UP).displayId(new Integer(i)).packageName(str).actionExtra((i6 > 0 || i10 > 0) ? new ActionExtra(i6, i10) : null).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_SCROLL_UP, j5, cVar);
    }

    public final Object setText(int i, String str, Integer num, Integer num2, String str2, String str3, String str4, long j5, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_SET_TEXT).displayId(new Integer(i)).packageName(str2).windowTitle(str3).activityClassName(str4).actionExtra(ActionExtra.setText(num != null ? num.intValue() : 0, num2 != null ? num2.intValue() : 0, str)).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_SET_TEXT, j5, cVar);
    }

    public final Object setTextWithTags(int i, String str, Integer num, Integer num2, String str2, String str3, String str4, long j5, H7.c<? super Boolean> cVar) {
        return setTextWithTags(i, str, 0L, TagWriteMode.CODE_POINT, num, num2, str2, str3, str4, j5, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object snapshot(java.lang.Integer r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, long r24, H7.c<? super com.mdisdk.capability.request.UiSnapshot> r26) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.UiCapabilityManager.snapshot(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, long, H7.c):java.lang.Object");
    }

    public final Object swipe(int i, int i6, int i10, int i11, int i12, long j5, String str, long j6, H7.c<? super Boolean> cVar) {
        RequestInfo requestInfoBuild = new RequestInfo.Builder().requestId(this.idGenerator.nextId()).function(RequestInfo.FUNCTION_SWIPE).displayId(new Integer(i)).packageName(str).actionExtra(ActionExtra.swipe(i6, i10, i11, i12, j5)).build();
        k.c(requestInfoBuild);
        return executeAction(requestInfoBuild, RequestInfo.FUNCTION_SWIPE, j6, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ce A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:26:0x007b, B:56:0x01c3, B:59:0x01ce, B:60:0x01e6, B:62:0x01ec, B:64:0x01f8, B:69:0x020c, B:70:0x0210, B:71:0x0218, B:73:0x021e, B:75:0x022a, B:76:0x022e, B:78:0x0234, B:85:0x026e, B:86:0x0277, B:88:0x027d, B:90:0x028d, B:92:0x0293, B:94:0x029d, B:97:0x02a7), top: B:109:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, w9.a] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [H7.c, com.mdisdk.capability.UiCapabilityManager$setTextWithTags$2] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setTextWithTags(int r26, java.lang.String r27, long r28, com.mdisdk.capability.TagWriteMode r30, java.lang.Integer r31, java.lang.Integer r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, long r36, H7.c<? super java.lang.Boolean> r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.UiCapabilityManager.setTextWithTags(int, java.lang.String, long, com.mdisdk.capability.TagWriteMode, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, long, H7.c):java.lang.Object");
    }
}

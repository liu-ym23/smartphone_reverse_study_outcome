package com.android.server.os.instrumentation;

import android.app.ActivityManagerInternal;
import android.content.Context;
import android.os.RemoteException;
import android.os.instrumentation.ExecutableMethodFileOffsets;
import android.os.instrumentation.IDynamicInstrumentationManager;
import android.os.instrumentation.IOffsetCallback;
import android.os.instrumentation.MethodDescriptor;
import android.os.instrumentation.MethodDescriptorParser;
import android.os.instrumentation.TargetProcess;
import com.android.internal.hidden_from_bootclasspath.com.android.art.flags.Flags;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import dalvik.system.VMDebug;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicInstrumentationManagerService extends SystemService {
    private ActivityManagerInternal mAmInternal;

    private final class BinderService extends IDynamicInstrumentationManager.Stub {
        final /* synthetic */ DynamicInstrumentationManagerService this$0;

        /* synthetic */ BinderService(DynamicInstrumentationManagerService r1, DynamicInstrumentationManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(DynamicInstrumentationManagerService r1) {
            this.this$0 = r1;
        }

        public void getExecutableMethodFileOffsets(TargetProcess targetProcess, MethodDescriptor methodDescriptor, final IOffsetCallback callback) {
            if (Flags.executableMethodFileOffsets() == false) goto L35;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DYNAMIC_INSTRUMENTATION", "Caller must have DYNAMIC_INSTRUMENTATION permission");
            targetProcess.processName.getClass();
            if (targetProcess.processName.equals("system_server") == false) goto L39;
            Executable executable = MethodDescriptorParser.parseMethodDescriptor(getClass().getClassLoader(), methodDescriptor);
            if (Flags.executableMethodFileOffsetsV2() == false) goto L20;
            VMDebug.ExecutableMethodFileOffsets location = VMDebug.getExecutableMethodFileOffsets(executable);
        L36:
            if (location == null) goto L24;
            ExecutableMethodFileOffsets ret = new ExecutableMethodFileOffsets();     // Catch: RemoteException -> L26
            ret.containerPath = location.getContainerPath();     // Catch: RemoteException -> L26
            ret.containerOffset = location.getContainerOffset();     // Catch: RemoteException -> L26
            ret.methodOffset = location.getMethodOffset();     // Catch: RemoteException -> L26
            callback.onResult(ret);     // Catch: RemoteException -> L26
            return;
        L24:
            callback.onResult(null);     // Catch: RemoteException -> L26
            return;
        L26:
            e = move-exception;
            throw new RuntimeException("Failed to invoke result callback", e);
        L20:
            if ((executable instanceof Method) == false) goto L33;
            location = VMDebug.getExecutableMethodFileOffsets((Method) executable);
            goto L36
        L33:
            throw new UnsupportedOperationException();
        L39:
            DynamicInstrumentationManagerService.m6447$$Nest$fgetmAmInternal(this.this$0).getExecutableMethodFileOffsets(targetProcess.processName, targetProcess.pid, targetProcess.uid, methodDescriptor, new AnonymousClass1(this, callback));     // Catch: NoSuchElementException -> L10
            return;
        L10:
            e = move-exception;
            NoSuchElementException e = e;
        L15:
            throw new IllegalArgumentException("The specified app process cannot be found.", e);
        L12:
            e = move-exception;
            e = e;
            goto L15
        L35:
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m6447$$Nest$fgetmAmInternal(DynamicInstrumentationManagerService r0) {
        return r0.mAmInternal;
    }

    public DynamicInstrumentationManagerService(Context context) {
        super(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        publishBinderService("dynamic_instrumentation", new BinderService(this, null));
    }
}

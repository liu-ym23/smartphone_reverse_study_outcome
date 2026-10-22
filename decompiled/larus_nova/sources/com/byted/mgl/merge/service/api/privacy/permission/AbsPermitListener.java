package com.byted.mgl.merge.service.api.privacy.permission;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AbsPermitListener {
    private static final String TAG = "PermissionsResultListener";
    private boolean mAnyPermissionDenied;
    private Looper mLooper;
    private final Set<String> mPermissions;
    private final List<PermitResult> mResultList;

    public abstract void onDenied(List<PermitResult> r100);

    public abstract void onGranted();

    public synchronized boolean shouldInvokeImmediatelyWhenDenied() {
        monitor-enter(this);
        monitor-exit(this);
        return true;
    }

    public AbsPermitListener() {
        this.mPermissions = new HashSet(1);
        this.mResultList = new ArrayList();
        this.mAnyPermissionDenied = false;
        this.mLooper = Looper.getMainLooper();
    }

    public AbsPermitListener(Looper r100) {
        this.mPermissions = new HashSet(1);
        this.mResultList = new ArrayList();
        this.mAnyPermissionDenied = false;
        Looper.getMainLooper();
        this.mLooper = r100;
    }

    public static /* synthetic */ List access$000(AbsPermitListener r100) {
        return r100.mResultList;
    }

    public final synchronized void registerPermissions(Set<String> r100) {
        monitor-enter(this);
        this.mPermissions.addAll(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean shouldIgnorePermissionNotFound(String r100) {
        monitor-enter(this);
        ((BdpLogService) BdpManager.getInst().getService(BdpLogService.class)).d(TAG, "Permission not found: " + r100);     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isDenied(String r100, PermitResult.Type r101) {
        if (r101 != PermitResult.Type.DENIED) goto L5;
    L10:
        return true;
    L5:
        if (shouldIgnorePermissionNotFound(r100) == false) goto L7;
    L9:
        return false;
    L7:
        if (r101 != PermitResult.Type.NOT_FOUND) goto L9;
        goto L9
    }

    public final synchronized boolean onResult(String r100, PermitResult.Type r101, boolean r102) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mPermissions.remove(r100) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        PermitResult r103 = new PermitResult(r100, r101, r102);     // Catch: Throwable -> L26
        this.mResultList.add(r103);     // Catch: Throwable -> L26
        boolean r104 = isDenied(r100, r103.resultType);     // Catch: Throwable -> L26
        if (shouldInvokeImmediatelyWhenDenied() == false) goto L14;
        if (r104 == false) goto L14;
        new Handler(this.mLooper).post(new AnonymousClass1(this));     // Catch: Throwable -> L26
        monitor-exit(this);
        return true;
    L14:
        if (r104 == false) goto L17;
        this.mAnyPermissionDenied = true;     // Catch: Throwable -> L26
    L17:
        if (this.mPermissions.isEmpty() == true) goto L19;
        monitor-exit(this);
        return false;
    L19:
        if (this.mAnyPermissionDenied == false) goto L21;
        new Handler(this.mLooper).post(new AnonymousClass2(this));     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return true;
    L21:
        new Handler(this.mLooper).post(new AnonymousClass3(this));     // Catch: Throwable -> L26
        goto L22
    }

    public final synchronized boolean onResult(String r100, int r101, boolean r102) {
        monitor-enter(this);
        if (r101 != 0) goto L7;
        boolean r103 = onResult(r100, PermitResult.Type.GRANTED, r102);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r103;
    L7:
        boolean r104 = onResult(r100, PermitResult.Type.DENIED, r102);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r104;
    L10:
        th = move-exception;
        throw th;
    }
}

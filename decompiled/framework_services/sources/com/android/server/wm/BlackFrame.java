package com.android.server.wm;

import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.io.PrintWriter;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class BlackFrame {
    private final BlackSurface[] mBlackSurfaces;
    private final Rect mInnerRect;
    private final Rect mOuterRect;
    private final Supplier<SurfaceControl.Transaction> mTransactionFactory;

    static class BlackSurface {
        final int layer;
        final int left;
        final SurfaceControl surface;
        final int top;

        BlackSurface(SurfaceControl.Transaction transaction, int layer, int l, int t, int r, int b, DisplayContent dc, SurfaceControl surfaceControl) throws Surface.OutOfResourcesException {
            this.left = l;
            this.top = t;
            this.layer = layer;
            int w = r - l;
            int h = b - t;
            this.surface = dc.makeOverlay().setName("BlackSurface").setColorLayer().setParent(surfaceControl).setCallsite("BlackSurface").build();
            transaction.setWindowCrop(this.surface, w, h);
            transaction.setAlpha(this.surface, 1.0f);
            transaction.setLayer(this.surface, layer);
            transaction.setPosition(this.surface, this.left, this.top);
            transaction.show(this.surface);
            if (ProtoLogImpl_798997914.Cache.WM_SHOW_SURFACE_ALLOC_enabled[2] == false) goto L6;
            String protoLogParam0 = String.valueOf(this.surface);
            long protoLogParam1 = layer;
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, -2963535976860666511L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
            return;
        }
    }

    public void printTo(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("Outer: ");
        this.mOuterRect.printShortString(pw);
        pw.print(" / Inner: ");
        this.mInnerRect.printShortString(pw);
        pw.println();
        int i = 0;
    L4:
        if (i >= this.mBlackSurfaces.length) goto L7;
        BlackSurface bs = this.mBlackSurfaces[i];
        pw.print(prefix);
        pw.print("#");
        pw.print(i);
        pw.print(": ");
        pw.print(bs.surface);
        pw.print(" left=");
        pw.print(bs.left);
        pw.print(" top=");
        pw.println(bs.top);
        i = i + 1;
        goto L4
    }

    public BlackFrame(Supplier<SurfaceControl.Transaction> factory, SurfaceControl.Transaction t, Rect outer, Rect inner, int layer, DisplayContent dc, boolean forceDefaultOrientation, SurfaceControl surfaceControl) throws Surface.OutOfResourcesException {
        this.mBlackSurfaces = new BlackSurface[4];
        this.mTransactionFactory = factory;
        this.mOuterRect = new Rect(outer);
        this.mInnerRect = new Rect(inner);
    L6:
        th = move-exception;
        if (0 != 0) goto L23;
        kill();
    L23:
        throw th;
    L4:
        if (outer.top >= inner.top) goto L9;
        this.mBlackSurfaces[0] = new BlackSurface(t, layer, outer.left, outer.top, inner.right, inner.top, dc, surfaceControl);     // Catch: Throwable -> L6
    L9:
        if (outer.left >= inner.left) goto L12;
        this.mBlackSurfaces[1] = new BlackSurface(t, layer, outer.left, inner.top, inner.left, outer.bottom, dc, surfaceControl);     // Catch: Throwable -> L6
    L12:
        if (outer.bottom <= inner.bottom) goto L15;
        this.mBlackSurfaces[2] = new BlackSurface(t, layer, inner.left, inner.bottom, outer.right, outer.bottom, dc, surfaceControl);     // Catch: Throwable -> L6
    L15:
        if (outer.right <= inner.right) goto L18;
        this.mBlackSurfaces[3] = new BlackSurface(t, layer, inner.right, outer.top, outer.right, inner.bottom, dc, surfaceControl);     // Catch: Throwable -> L6
    L18:
        if (1 != 0) goto L26;
        kill();
        return;
    }

    public void kill() {
        SurfaceControl.Transaction t = this.mTransactionFactory.get();
        int i = 0;
    L4:
        if (i >= this.mBlackSurfaces.length) goto L12;
        if (this.mBlackSurfaces[i] == null) goto L11;
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_SURFACE_ALLOC_enabled[2] == false) goto L10;
        String protoLogParam0 = String.valueOf(this.mBlackSurfaces[i].surface);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, -5633771912572750947L, 0, new Object[]{protoLogParam0});
    L10:
        t.remove(this.mBlackSurfaces[i].surface);
        this.mBlackSurfaces[i] = null;
    L11:
        i = i + 1;
        goto L4
    L12:
        t.apply();
    }
}

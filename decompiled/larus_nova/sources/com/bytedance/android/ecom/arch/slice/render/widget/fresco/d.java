package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

import android.graphics.drawable.Animatable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes44.dex */
public class d<INFO> extends BaseControllerListener<INFO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ControllerListener<? super INFO>> f50935a;

    public final synchronized List<ControllerListener<? super INFO>> a() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList(2);     // Catch: Throwable -> L6
        r100.addAll(this.f50935a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void clearListeners() {
        monitor-enter(this);
        ((ArrayList) this.f50935a).clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public d() {
        this.f50935a = new ArrayList(2);
    }

    public final synchronized void addListener(ControllerListener<? super INFO> r100) {
        monitor-enter(this);
        ((ArrayList) this.f50935a).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Throwable r100) {
        monitor-enter(this);
        nq.a.b(r100, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void onRelease(String r100) {
        monitor-enter(this);
        List<ControllerListener<? super INFO>> r101 = a();     // Catch: Throwable -> L15
        int r102 = ((ArrayList) r101).size();     // Catch: Throwable -> L15
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        ControllerListener r104 = (ControllerListener) ListProtector.get(r101, r103);     // Catch: Exception -> L10 Throwable -> L15
        if (r104 == null) goto L12;
        r104.onRelease(r100);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r103 = r103 + 1;
    L10:
        e = move-exception;
        b(e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void onControllerStart(ImageRequest r100, long r101) {
        List<ControllerListener<? super INFO>> r102 = a();
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L13;
        ControllerListener r105 = (ControllerListener) ListProtector.get(r102, r104);     // Catch: Exception -> L10
        if (r105 == null) goto L12;
        if ((r105 instanceof BaseControllerListener) == false) goto L12;
        ((BaseControllerListener) r105).onControllerStart(r100, r101);     // Catch: Exception -> L10
    L12:
        r104 = r104 + 1;
    L10:
        e = move-exception;
        b(e);
        goto L12
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void onFailure(String r100, Throwable r101) {
        monitor-enter(this);
        List<ControllerListener<? super INFO>> r102 = a();     // Catch: Throwable -> L15
        int r103 = ((ArrayList) r102).size();     // Catch: Throwable -> L15
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        ControllerListener r105 = (ControllerListener) ListProtector.get(r102, r104);     // Catch: Exception -> L10 Throwable -> L15
        if (r105 == null) goto L12;
        r105.onFailure(r100, r101);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r104 = r104 + 1;
    L10:
        e = move-exception;
        b(e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
        List<ControllerListener<? super INFO>> r102 = a();
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        ControllerListener r105 = (ControllerListener) ListProtector.get(r102, r104);     // Catch: Exception -> L8
        if (r105 == null) goto L10;
        r105.onIntermediateImageFailed(r100, r101);     // Catch: Exception -> L8
    L10:
        r104 = r104 + 1;
    L8:
        e = move-exception;
        b(e);
        goto L10
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, @Nullable INFO r101) {
        List<ControllerListener<? super INFO>> r102 = a();
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        ControllerListener r105 = (ControllerListener) ListProtector.get(r102, r104);     // Catch: Exception -> L8
        if (r105 == null) goto L10;
        r105.onIntermediateImageSet(r100, r101);     // Catch: Exception -> L8
    L10:
        r104 = r104 + 1;
    L8:
        e = move-exception;
        b(e);
        goto L10
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void onSubmit(String r100, Object r101) {
        monitor-enter(this);
        List<ControllerListener<? super INFO>> r102 = a();     // Catch: Throwable -> L15
        int r103 = ((ArrayList) r102).size();     // Catch: Throwable -> L15
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        ControllerListener r105 = (ControllerListener) ListProtector.get(r102, r104);     // Catch: Exception -> L10 Throwable -> L15
        if (r105 == null) goto L12;
        r105.onSubmit(r100, r101);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r104 = r104 + 1;
    L10:
        e = move-exception;
        b(e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void onFinalImageSet(String r100, @Nullable INFO r101, @Nullable Animatable r102) {
        monitor-enter(this);
        List<ControllerListener<? super INFO>> r103 = a();     // Catch: Throwable -> L15
        int r104 = ((ArrayList) r103).size();     // Catch: Throwable -> L15
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L13;
        ControllerListener r106 = (ControllerListener) ListProtector.get(r103, r105);     // Catch: Exception -> L10 Throwable -> L15
        if (r106 == null) goto L12;
        r106.onFinalImageSet(r100, r101, r102);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r105 = r105 + 1;
    L10:
        e = move-exception;
        b(e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void onIntermediateImageSet(String r100, @Nullable INFO r101, @Nullable Animatable r102) {
        List<ControllerListener<? super INFO>> r103 = a();
        int r104 = ((ArrayList) r103).size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        ControllerListener r106 = (ControllerListener) ListProtector.get(r103, r105);     // Catch: Exception -> L8
        if ((r106 instanceof BaseControllerListener) == false) goto L10;
        ((BaseControllerListener) r106).onIntermediateImageSet(r100, r101, r102);     // Catch: Exception -> L8
    L10:
        r105 = r105 + 1;
    L8:
        e = move-exception;
        b(e);
        goto L10
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void onFinalImageSet(String r110, @Nullable INFO r111, @Nullable Animatable r112, ImageRequest r113, Map r114) {
        List<ControllerListener<? super INFO>> r100 = a();
        int r101 = ((ArrayList) r100).size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L22;
        ControllerListener r103 = (ControllerListener) ListProtector.get(r100, r102);     // Catch: Exception -> L17
        if (r103 == null) goto L20;
        if ((r103 instanceof BaseControllerListener) == false) goto L23;
        ((BaseControllerListener) r103).onFinalImageSet(r110, r111, r112, r113, r114);     // Catch: Exception -> L17
        goto L20
    L23:
        r103.onFinalImageSet(r110, r111, r112);     // Catch: Exception -> L13
    L13:
        e = e;
    L19:
        b(e);
    L20:
        r102 = r102 + 1;
    L17:
        e = e;
        goto L19
    }
}

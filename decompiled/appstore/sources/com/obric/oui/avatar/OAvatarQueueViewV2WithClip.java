package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import nc.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueViewV2WithClip;", "Landroid/view/View;", "Lcom/obric/oui/avatar/IOAvatarQueueViewV2WithClipOperation;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lnc/a;", "param", "", "init", "(Lnc/a;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "mPaint", "", "Landroid/graphics/Bitmap;", "b", "Ljava/util/List;", "mAvatarBitmapQueue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueViewV2WithClip extends View implements IOAvatarQueueViewV2WithClipOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f12363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f12364b;

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(@NotNull Context r10) {
        q.g(r10, "ctx");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // com.obric.oui.avatar.IOAvatarQueueViewV2WithClipOperation
    public void init(a r10) {
        q.g(r10, "param");
        q.y("inParam");
        throw null;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.onDraw(r10);
    }

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "ctx");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OAvatarQueueViewV2WithClip(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OAvatarQueueViewV2WithClip(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "ctx");
        super(r10, r11, r12);
        Paint r13 = new Paint();
        r13.setAntiAlias(true);
        this.f12363a = r13;
        this.f12364b = new ArrayList();
    }
}

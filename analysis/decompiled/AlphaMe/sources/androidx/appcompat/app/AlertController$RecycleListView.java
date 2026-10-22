package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import g.AbstractC0560a;

/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final int f2458a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2459b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12607t);
        this.f2459b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f2458a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}

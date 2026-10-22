package com.stepos.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import j4.g;
import j4.k;

/* loaded from: classes.dex */
public final class StepOSDialogListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private static final a f16149a = new a(null);

    private static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSDialogListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.g(context, "context");
    }

    public final void a(boolean z5, boolean z6) {
        if (z6 && z5) {
            return;
        }
        setPaddingRelative(getPaddingStart(), z5 ? getPaddingTop() : 0, getPaddingEnd(), z6 ? getPaddingBottom() : 0);
    }
}

package com.bytedanceos.appstore.buss.beta.manager;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/manager/ScrollLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", WsConstants.KEY_CONNECTION_STATE, "", "position", "", "smoothScrollToPosition", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;I)V", "a", "b", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScrollLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8424a = null;

    public static final class a extends h {
        public a(Context r10) {
            super(r10);
        }

        @Override // androidx.recyclerview.widget.h
        public int calculateDtToFit(int r10, int r11, int r12, int r13, int r14) {
            return (r12 + ((int) (((double) (r13 - r12)) * 0.382d))) - (r10 + ((r11 - r10) / 2));
        }

        @Override // androidx.recyclerview.widget.h
        public float calculateSpeedPerPixel(DisplayMetrics r10) {
            q.g(r10, "displayMetrics");
            return 100.0f / r10.densityDpi;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f8424a = new b(null);
    }

    public ScrollLayoutManager(@Nullable Context r10) {
        super(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r10, RecyclerView.State r11, int r12) {
        q.g(r10, "recyclerView");
        q.g(r11, WsConstants.KEY_CONNECTION_STATE);
        super.smoothScrollToPosition(r10, r11, r12);
        a r13 = new a(r10.getContext());
        r13.setTargetPosition(r12);
        startSmoothScroll(r13);
    }
}

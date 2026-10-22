package com.bytedance.android.livesdk.interactivity.common.business.quickcomment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class QuickCommentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f136437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f136438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f136439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f136440d;

    public interface a {
        void a(QuickCommentView r100);

        void b(IQuickCommentShowWord r100);
    }

    public static class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<IQuickCommentShowWord> f136441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f136442b;

        public interface a {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f136441a).size();
        }

        public b() {
            this.f136441a = new ArrayList();
            this.f136442b = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            c r102 = (c) r100;
            IQuickCommentShowWord r103 = (IQuickCommentShowWord) ListProtector.get(this.f136441a, r101);
            r102.f136443a.setTag(r103);
            TextView r104 = r102.f136443a;
            SpannableString r105 = new SpannableString(r103.getContent());
            ab2.a.e(r105, s1.f(16.0f));
            r104.setText(r105);
            if (TextUtils.isEmpty(r103.getBackgroundColor()) == false) goto L10;
            r102.f136443a.setBackgroundResource(R.drawable.ttlive_bg_quick_comment_item);
        L8:
            r102.itemView.setTag(R.id.ttlive_quick_comment_view, Integer.valueOf(r101));
            return;
        L10:
            int r106 = Color.parseColor(r103.getBackgroundColor());     // Catch: IllegalArgumentException -> L6
            GradientDrawable r107 = new GradientDrawable();     // Catch: IllegalArgumentException -> L6
            r107.setColor(r106);     // Catch: IllegalArgumentException -> L6
            r107.setCornerRadius(s1.f(14.0f));     // Catch: IllegalArgumentException -> L6
            r102.f136443a.setBackground(r107);     // Catch: IllegalArgumentException -> L6
        L6:
            r102.f136443a.setBackgroundResource(R.drawable.ttlive_bg_quick_comment_item);
            goto L8
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return new c(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_quick_comment, r100, false), this.f136442b);
        }
    }

    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f136443a;

        public c(View r100, final b.a r101) {
            super(r100);
            TextView r102 = (TextView) r100.findViewById(R.id.content);
            this.f136443a = r102;
            r102.setOnClickListener(new m72.c(this, r101));
        }
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_quick_comment, this);
        RecyclerView r100 = (RecyclerView) findViewById(R.id.recycler_view);
        this.f136437a = r100;
        r100.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        b r101 = new b();
        this.f136438b = r101;
        this.f136437a.setAdapter(r101);
        b r102 = this.f136438b;
        r102.f136442b = new m72.a(this);
        setOnClickListener(new m72.b(this));
    }

    public QuickCommentView(Context r100) {
        super(r100);
        this.f136440d = false;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (this.f136437a == null) goto L13;
        if (r100.getAction() != 0) goto L13;
        if (this.f136437a.canScrollHorizontally(-1) == false) goto L9;
    L10:
        r101 = true;
    L11:
        this.f136440d = r101;
    L20:
        return super.dispatchTouchEvent(r100);
    L9:
        if (this.f136437a.canScrollHorizontally(1) == false) goto L11;
    L13:
        if (r100.getAction() != 3) goto L15;
    L18:
        this.f136440d = false;
        goto L20
    L15:
        if (r100.getAction() == 1) goto L18;
        if (this.f136437a != null) goto L20;
        goto L18
    }

    public void setListener(a r100) {
        this.f136439c = r100;
    }

    public void setQuickComment(List<IQuickCommentShowWord> r100) {
        b r101 = this.f136438b;
        if (r101 == null) goto L6;
        ((ArrayList) r101.f136441a).clear();
        ((ArrayList) r101.f136441a).addAll(r100);
        r101.notifyDataSetChanged();
        return;
    }

    public QuickCommentView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f136440d = false;
        a();
    }

    public QuickCommentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f136440d = false;
        a();
    }
}

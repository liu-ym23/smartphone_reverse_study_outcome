package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.am;
import com.obric.autoaction.app.launcherpage.donation.model.Question;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataDonationTaskListActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DataDonationTaskListActivity extends AppCompatActivity implements com.obric.autoaction.app.launcherpage.b.a {
    public static final a Companion = null;
    private static final String TAG = "DataDonationTaskListAct";
    private am binding;
    private final com.obric.autoaction.app.launcherpage.donation.a.a headerAdapter;
    private j sortAdapter;
    private final x<h> statueFlow;

    /* JADX INFO: compiled from: DataDonationTaskListActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r2);
            ZeusTransformUtils.startActivity(r2, new Intent(r2, DataDonationTaskListActivity.class), "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DataDonationTaskListActivity.kt */
    @d.c.b.a.f(b = "DataDonationTaskListActivity.kt", c = {103}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity$initView$3")
    static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataDonationTaskListActivity f23674b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: DataDonationTaskListActivity.kt */
        @d.c.b.a.f(b = "DataDonationTaskListActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity$initView$3$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<h, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23675a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f23676b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DataDonationTaskListActivity f23677c;

            AnonymousClass1(DataDonationTaskListActivity r3, d.c.d<? super AnonymousClass1> r4) {
                DataDonationTaskListActivity r5 = (DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23677c = r5;
                super(2, r6);
            }

            public final Object a(h r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f23677c, r5);
                r0.f23676b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(h r3, d.c.d<? super d.x> r4) {
                return a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                d.c.a.b.a();
                if (this.f23675a != 0) goto L33;
                d.o.a(r8);
                h r9 = (h) ZeusTransformUtils.preCheckCast(this.f23676b, h.class, "com.obric.aiagent.plugin");
                am r4 = null;
                if (o.a(r9, h.a.f23763a) == false) goto L7;
            L25:
                DataDonationTaskListActivity.access$getHeaderAdapter$p(this.f23677c).b(false);
                am r10 = DataDonationTaskListActivity.access$getBinding$p(this.f23677c);
                if (r10 != null) goto L28;
                o.c("binding");
            L29:
                OPageStatus r11 = r4.f22753b;
                DataDonationTaskListActivity r7 = this.f23677c;
                r11.removeAllViews();
                r11.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.getString(ZeusTransformUtils.mapRes(R.string.empty_task_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "empty_task_tips")), CharSequence.class, "com.obric.aiagent.plugin"));
            L31:
                return d.x.f38692a;
            L28:
                r4 = r10;
                goto L29
            L7:
                if (o.a(r9, h.b.f23764a) == true) goto L25;
                if (o.a(r9, h.c.f23765a) == false) goto L17;
                DataDonationTaskListActivity.access$getHeaderAdapter$p(this.f23677c).b(false);
                am r12 = DataDonationTaskListActivity.access$getBinding$p(this.f23677c);
                if (r12 != null) goto L14;
                o.c("binding");
            L15:
                OPageStatus r13 = r4.f22753b;
                DataDonationTaskListActivity r14 = this.f23677c;
                r13.showLoading(true);
                r13.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.string.loading, WsChannelMultiProcessSharedProvider.STRING_TYPE, "loading")), CharSequence.class, "com.obric.aiagent.plugin"));
                goto L31
            L14:
                r4 = r12;
                goto L15
            L17:
                if (o.a(r9, h.d.f23766a) == false) goto L24;
                DataDonationTaskListActivity.access$getHeaderAdapter$p(this.f23677c).b(true);
                am r15 = DataDonationTaskListActivity.access$getBinding$p(this.f23677c);
                if (r15 != null) goto L21;
                o.c("binding");
            L22:
                r4.f22753b.setVisibility(8);
                goto L31
            L21:
                r4 = r15;
                goto L22
            L24:
                throw new d.k();
            L33:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(DataDonationTaskListActivity r3, d.c.d<? super b> r4) {
            DataDonationTaskListActivity r5 = (DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23674b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23674b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23673a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(DataDonationTaskListActivity.access$getStatueFlow$p(this.f23674b), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23674b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23673a = 1;
            if (kotlinx.coroutines.b.j.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DataDonationTaskListActivity.kt */
    @d.c.b.a.f(b = "DataDonationTaskListActivity.kt", c = {57, 58}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity$onCreate$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataDonationTaskListActivity f23679b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: DataDonationTaskListActivity.kt */
        @d.c.b.a.f(b = "DataDonationTaskListActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity$onCreate$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23680a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ List<com.obric.autoaction.app.launcherpage.donation.model.b> f23681b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DataDonationTaskListActivity f23682c;

            AnonymousClass1(List<com.obric.autoaction.app.launcherpage.donation.model.b> r3, DataDonationTaskListActivity r4, d.c.d<? super AnonymousClass1> r5) {
                List<com.obric.autoaction.app.launcherpage.donation.model.b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                DataDonationTaskListActivity r7 = (DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r4, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23681b = r6;
                this.f23682c = r7;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23681b, this.f23682c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f23680a != 0) goto L19;
                d.o.a(r5);
                if (this.f23681b.isEmpty() == false) goto L10;
                x r6 = DataDonationTaskListActivity.access$getStatueFlow$p(this.f23682c);
            L7:
                Object r4 = r6.c();
                h r1 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin");
                if (r6.a(r4, (h) ZeusTransformUtils.preCheckCast(h.a.f23763a, h.class, "com.obric.aiagent.plugin")) == false) goto L7;
            L17:
                return d.x.f38692a;
            L10:
                x r7 = DataDonationTaskListActivity.access$getStatueFlow$p(this.f23682c);
            L11:
                Object r2 = r7.c();
                h r3 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
                if (r7.a(r2, (h) ZeusTransformUtils.preCheckCast(h.d.f23766a, h.class, "com.obric.aiagent.plugin")) == false) goto L11;
                j r8 = DataDonationTaskListActivity.access$getSortAdapter$p(this.f23682c);
                if (r8 == null) goto L17;
                r8.a(this.f23681b);
                goto L17
            L19:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(DataDonationTaskListActivity r3, d.c.d<? super c> r4) {
            DataDonationTaskListActivity r5 = (DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23679b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23679b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23678a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L17:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
            d.c.g r2 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");
            d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, this.f23679b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23678a = 2;
            if (kotlinx.coroutines.i.a(r2, r10, r3) != r0) goto L17;
            return r0;
        L10:
            d.o.a(r8);
            DataDonationTaskListActivity r11 = this.f23679b;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23678a = 1;
            r8 = DataDonationTaskListActivity.access$requestTaskList(r11, r4);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DataDonationTaskListActivity.kt */
    @d.c.b.a.f(b = "DataDonationTaskListActivity.kt", c = {139}, d = "requestTaskList", e = "com.obric.autoaction.app.launcherpage.donation.DataDonationTaskListActivity")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DataDonationTaskListActivity f23685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23686d;

        d(DataDonationTaskListActivity r3, d.c.d<? super d> r4) {
            DataDonationTaskListActivity r5 = (DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23685c = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23684b = r3;
            this.f23686d |= Integer.MIN_VALUE;
            return DataDonationTaskListActivity.access$requestTaskList(this.f23685c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$vWcx8ihs-9BDYjn-Azaq9R3mxXg, reason: not valid java name */
    public static /* synthetic */ void m499lambda$vWcx8ihs9BDYjnAzaq9R3mxXg(DataDonationTaskListActivity r0, View r1) {
        initView$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ void lambda$y72RPJlMaUOy_ZAlqOWWQ_5kPcs(DataDonationTaskListActivity r0, View r1) {
        initView$lambda$2$lambda$0(r0, r1);
    }

    public DataDonationTaskListActivity() {
        this.headerAdapter = new com.obric.autoaction.app.launcherpage.donation.a.a();
        this.statueFlow = kotlinx.coroutines.b.am.a(h.c.f23765a);
    }

    public static final /* synthetic */ am access$getBinding$p(DataDonationTaskListActivity r2) {
        return ((DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.donation.a.a access$getHeaderAdapter$p(DataDonationTaskListActivity r2) {
        return ((DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin")).headerAdapter;
    }

    public static final /* synthetic */ j access$getSortAdapter$p(DataDonationTaskListActivity r2) {
        return ((DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin")).sortAdapter;
    }

    public static final /* synthetic */ x access$getStatueFlow$p(DataDonationTaskListActivity r2) {
        return ((DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin")).statueFlow;
    }

    public static final /* synthetic */ Object access$requestTaskList(DataDonationTaskListActivity r2, d.c.d r3) {
        return ((DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin")).requestTaskList((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r11) {
        super.onCreate(r11);
        am r12 = am.a(getLayoutInflater(), null, false);
        o.c(r12, "inflate(...)");
        this.binding = r12;
        if (r12 != null) goto L5;
        o.c("binding");
        r12 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r12.b(), View.class, "com.obric.aiagent.plugin"));
        BaseActivity.a.a(BaseActivity.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 1, null);
        initView();
        kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void initView() {
        am r0 = this.binding;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.f22755d;
        r1.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addStartAction$default(r1, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$DataDonationTaskListActivity$y72RPJlMaUOy_ZAlqOWWQ_5kPcs(this), 2, null);
        r1.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addEndAction$default(r1, ZeusTransformUtils.mapRes(R.drawable.icon_clock, "drawable", "icon_clock"), 0, new $$Lambda$DataDonationTaskListActivity$vWcx8ihs9BDYjnAzaq9R3mxXg(this), 2, null);
        o.a(r1);
        com.obric.autoaction.app.launcherpage.b.c.a(r1);
        am r2 = this.binding;
        if (r2 != null) goto L8;
        o.c("binding");
        r2 = null;
    L8:
        final RecyclerView r3 = r2.f22754c;
        r3.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new DataDonationTaskListActivity$initView$2$1(this, r3), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r3.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.view.b(d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()))), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        j r4 = new j();
        this.sortAdapter = r4;
        r3.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(new androidx.recyclerview.widget.g(new RecyclerView.a[]{this.headerAdapter, r4}), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        am r5 = this.binding;
        if (r5 != null) goto L11;
        o.c("binding");
        r5 = null;
    L11:
        RecyclerView r6 = r5.f22754c;
        o.c(r6, "questionList");
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin");
        am r8 = this.binding;
        if (r8 != null) goto L14;
        o.c("binding");
        r8 = null;
    L14:
        OFloatingTitleBar r9 = r8.f22755d;
        o.c(r9, "titleBar");
        com.obric.autoaction.app.launcherpage.utils.p.a(r7, r9, false, 2, null);
        q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")).b((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private static final void initView$lambda$2$lambda$0(DataDonationTaskListActivity r1, View r2) {
        ((DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r1, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private static final void initView$lambda$2$lambda$1(DataDonationTaskListActivity r2, View r3) {
        DataDonationTaskListActivity r4 = (DataDonationTaskListActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin");
        UploadRecordActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.b.a
    public OFloatingTitleBar getFloatingTransitionSourceTitleBar() {
        am r1 = this.binding;
        if (r1 == null) goto L8;
        if (r1 != null) goto L7;
        o.c("binding");
        r1 = null;
    L7:
        return r1.f22755d;
    L8:
        return null;
    }

    private final Object requestTaskList(d.c.d<? super List<com.obric.autoaction.app.launcherpage.donation.model.b>> r27) {
        DataDonationTaskListActivity r0 = this;
        String r1 = DbHelper.COL_ID;
        String r4 = "com.obric.aiagent.plugin";
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L7;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
        if ((r5.f23686d & Integer.MIN_VALUE) == 0) goto L7;
        r5.f23686d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f23684b;
        Object r7 = d.c.a.b.a();
        int r8 = r5.f23686d;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L17;
        r0 = (DataDonationTaskListActivity) ZeusTransformUtils.preCheckCast(r5.f23683a, DataDonationTaskListActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L14
    L25:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r9 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r9.a() == true) goto L29;
        com.obric.autogui.tools.api.net.b r2 = r9.a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        r2.b();     // Catch: Throwable -> L14
        Loog.INSTANCE.e(TAG, "requestTaskList failed: " + r2.getType());     // Catch: Throwable -> L14
        return d.a.p.b();
    L29:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Loog.INSTANCE.i(TAG, "requestTaskList: " + r10);     // Catch: Throwable -> L14
        if (r9.a() == false) goto L58;
        if (r10 == null) goto L58;
        JSONObject r11 = new JSONObject(r10).getJSONObject("data");     // Catch: Throwable -> L14
        String r12 = r11.optString("agreement");     // Catch: Throwable -> L14
        if (r12 != null) goto L35;
        r12 = "";
    L35:
        com.obric.autoaction.app.launcherpage.donation.c.f23730a.a(r12);     // Catch: Throwable -> L14
        JSONArray r13 = r11.optJSONArray("sorts");     // Catch: Throwable -> L14
        if (r13 == null) goto L38;
        List r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        int r15 = r13.length();     // Catch: Throwable -> L14
        int r16 = 0;
    L40:
        if (r16 >= r15) goto L57;
        JSONObject r17 = r13.optJSONObject(r16);     // Catch: Throwable -> L14
        if (r17 != null) goto L44;
        JSONArray r28 = r13;
        String r23 = r1;
        String r24 = r4;
        int r25 = r15;
    L56:
        r16 = r16 + 1;     // Catch: Throwable -> L14
        r13 = r28;
        r1 = r23;
        r4 = r24;
        r15 = r25;
        goto L40
    L44:
        String r18 = r17.optString(r1);     // Catch: Throwable -> L14
        String r19 = r17.optString("sort");     // Catch: Throwable -> L14
        o.c(r19, "optString(...)");     // Catch: Throwable -> L14
        JSONArray r110 = r17.optJSONArray("question");     // Catch: Throwable -> L14
        if (r110 == null) goto L54;
        List r111 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, r4);     // Catch: Throwable -> L14
        int r112 = r110.length();     // Catch: Throwable -> L14
        int r113 = 0;
    L47:
        if (r113 >= r112) goto L53;
        JSONObject r20 = r110.optJSONObject(r113);     // Catch: Throwable -> L14
        if (r20 == null) goto L52;
        long r114 = r20.optLong(r1);     // Catch: Throwable -> L14
        String r21 = r20.optString("name");     // Catch: Throwable -> L14
        o.c(r21, "optString(...)");     // Catch: Throwable -> L14
        String r22 = r20.optString("reward");     // Catch: Throwable -> L14
        String r26 = r20.optString(DBHelper.BATTERY_COL_PROCESS_NAME);     // Catch: Throwable -> L14
        o.c(r26, "optString(...)");     // Catch: Throwable -> L14
        String r29 = r20.optString("require");     // Catch: Throwable -> L14
        o.c(r29, "optString(...)");     // Catch: Throwable -> L14
        r111.add(new Question(r114, r21, r22, r26, r29));     // Catch: Throwable -> L14
    L52:
        r113 = r113 + 1;     // Catch: Throwable -> L14
        r13 = r13;
        r1 = r1;
        r4 = r4;
        r15 = r15;
        goto L47
    L53:
        r28 = r13;
        r23 = r1;
        r24 = r4;
        r25 = r15;
    L55:
        r14.add(new com.obric.autoaction.app.launcherpage.donation.model.b(r18, r19, r111));     // Catch: Throwable -> L14
        goto L56
    L54:
        r28 = r13;
        r23 = r1;
        r24 = r4;
        r25 = r15;
        r111 = d.a.p.b();     // Catch: Throwable -> L14
        goto L55
    L57:
        return r14;
    L38:
        return d.a.p.b();
    L58:
        Object r30 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L14
    L61:
        Throwable r31 = d.n.c(r30);
        if (r31 == null) goto L65;
        Loog.INSTANCE.e(TAG, "requestTaskList: " + r31.getMessage(), r31);
    L65:
        return d.a.p.b();
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r6);
        com.obric.autogui.tools.api.net.a r32 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r32 == null) goto L21;
        d.n.a r33 = d.n.f38560a;     // Catch: Throwable -> L14
        String r34 = com.obric.aiagent.product.a.a.f18769a.a("auto_action/api/donation/bank");     // Catch: Throwable -> L14
        Map<String, String> r115 = ao.b();     // Catch: Throwable -> L14
        r5.f23683a = r0;     // Catch: Throwable -> L14
        r5.f23686d = 1;     // Catch: Throwable -> L14
        r6 = r32.a(r34, r115, 60000, r5);     // Catch: Throwable -> L14
        if (r6 != r7) goto L25;
        return r7;
    L21:
        return d.a.p.b();
    L14:
        th = move-exception;
        d.n.a r35 = d.n.f38560a;
        r30 = d.n.f(d.o.a(th));
    L7:
        r5 = new d(r0, r3);
        goto L8
    }
}

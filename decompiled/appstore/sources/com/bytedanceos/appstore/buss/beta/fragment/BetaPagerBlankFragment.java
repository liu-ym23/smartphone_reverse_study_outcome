package com.bytedanceos.appstore.buss.beta.fragment;

import androidx.fragment.app.Fragment;
import com.obric.appstore.R;
import h7.c;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003R\u0014\u0010\f\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/fragment/BetaPagerBlankFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "f", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaPagerBlankFragment extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8406f = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a() {
            return new BetaPagerBlankFragment();
        }

        public a() {
        }
    }

    static {
        f8406f = new a(null);
    }

    public BetaPagerBlankFragment() {
    }

    @Override // h7.c
    public void E() {
        r();
    }

    @Override // h7.c
    public void F() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // h7.c
    public void initData() {
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_pager_blank;
    }

    @Override // h7.c
    public Function0 o() {
        return BetaPagerBlankFragment$onRetryListener$1.INSTANCE;
    }

    @Override // h7.c
    public void t() {
    }
}

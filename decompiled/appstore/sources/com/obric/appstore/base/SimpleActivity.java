package com.obric.appstore.base;

import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/base/SimpleActivity;", "Lcom/obric/appstore/base/BaseActivity;", "<init>", "()V", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "v", "()Ljava/lang/Class;", "mFragmentClass", "e", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SimpleActivity extends BaseActivity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f10559e = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Intent a(Context r10, Class r11) {
            q.g(r10, "context");
            q.g(r11, "fragmentClass");
            Intent r12 = new Intent(r10, SimpleActivity.class);
            r12.putExtra("__extra_fragment_class", r11);
            return r12;
        }

        public a() {
        }
    }

    static {
        f10559e = new a(null);
    }

    public SimpleActivity() {
    }

    @Override // com.obric.appstore.base.BaseActivity
    public Class v() {
        Serializable r10 = getIntent().getSerializableExtra("__extra_fragment_class");
        if ((r10 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r10;
    }
}

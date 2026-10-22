package com.obric.oui.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StubViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends d {
    public static final a r = null;

    /* JADX INFO: compiled from: StubViewHolder.kt */
    public static final class a implements f {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        @Override // com.obric.oui.banner.f
        public String a() {
            return "_stub";
        }

        private a() {
        }

        @Override // com.obric.oui.banner.f
        public d a(ViewGroup r3) {
            o.e(r3, "parent");
            View r2 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return (d) ZeusTransformUtils.preCheckCast(new i(r2), d.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        r = new a(null);
    }

    @Override // com.obric.oui.banner.d
    public void a(b r2) {
        o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "data");
    }

    public i(View r2) {
        o.e(r2, "view");
        super(r2);
    }
}

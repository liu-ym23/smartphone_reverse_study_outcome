package com.stepos.aiengine.modelmanager.pref;

import android.content.Context;
import android.text.TextUtils;
import com.stepos.aiengine.R;
import h6.s;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelPreference extends BaseEnginePreference {
    public final boolean R;
    public int S;
    public int T;
    public final l<s, n> U;
    public final l<s, n> V;
    public s W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ModelPreference(Context context, s row, boolean z, int i10, int i11, l<? super s, n> lVar, l<? super s, n> lVar2) {
        super(context, null);
        g.f(row, "row");
        this.R = z;
        this.S = i10;
        this.T = i11;
        this.U = lVar;
        this.V = lVar2;
        this.W = row;
        this.I = R.layout.pref_model;
        if (this.f2361t) {
            this.f2361t = false;
            j();
        }
        this.f2363v = false;
        String str = row.f9339b;
        this.f2357o = str;
        if (this.f2362u && TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f2357o)) {
                throw new IllegalStateException("Preference does not have a key assigned.");
            }
            this.f2362u = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x004b  */
    @Override // androidx.preference.Preference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(androidx.preference.h r18) {
        /*
            Method dump skipped, instructions count: 862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.modelmanager.pref.ModelPreference.n(androidx.preference.h):void");
    }
}

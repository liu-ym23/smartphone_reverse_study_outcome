package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f134969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f134970b;

    public abstract void a(View r100);

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_frequent_chat_confirm_dialog, null);
        setContentView(r101);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        a(r101);
        ((TextView) r101.findViewById(R.id.confirm)).setOnClickListener(new a(this));
        ((TextView) r101.findViewById(R.id.cancel)).setOnClickListener(new b(this));
    }

    public c(Context r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cancelOperation");
        Intrinsics.checkNotNullParameter(r102, "confirmOperation");
        super(r100, R.style.ttlive_live_dialog);
        this.f134969a = r101;
        this.f134970b = r102;
    }
}

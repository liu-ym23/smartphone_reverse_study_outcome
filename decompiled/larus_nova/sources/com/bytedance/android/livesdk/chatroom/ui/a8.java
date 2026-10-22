package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a8 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f112583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f112584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f112585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f112586d;

    public a8(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_loading_place_holder, this, true);
        this.f112583a = (ViewGroup) findViewById(R.id.place_container);
        this.f112584b = (ImageView) findViewById(R.id.place_holder_img);
        this.f112585c = (TextView) findViewById(R.id.place_holder_title);
        this.f112586d = (TextView) findViewById(R.id.place_holder_label);
    }
}

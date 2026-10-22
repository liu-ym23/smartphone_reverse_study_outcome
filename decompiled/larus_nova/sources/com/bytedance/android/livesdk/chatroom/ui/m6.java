package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class m6 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f113709a;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_hint_kicked_out, null);
        TextView r102 = (TextView) r101.findViewById(R.id.tv_hint_kicked_out);
        if (r102 == null) goto L7;
        String r103 = this.f113709a;
        if (r103 == null) goto L7;
        r102.setText(r103);
    L7:
        setContentView(r101);
        Window r104 = getWindow();
        if (r104 == null) goto L11;
        r104.setGravity(17);
        return;
    }

    public m6(Context r100, String r101) {
        super(r100, R.style.ttlive_kick_dialog);
        this.f113709a = null;
        this.f113709a = r101;
    }
}

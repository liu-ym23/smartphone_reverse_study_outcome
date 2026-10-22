package com.stepos.ailauncher.chat.activity;

import La.C0953c;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.model.PolicyDocument;
import h8.C4148a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/LocalPolicyActivity;", "Lb/q;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "", "name", "p", "(Ljava/lang/String;)Ljava/lang/String;", "html", "Landroid/text/Spanned;", "kotlin.jvm.PlatformType", "q", "(Ljava/lang/String;)Landroid/text/Spanned;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalPolicyActivity extends b.q {
    public static final String EXTRA_DOCUMENT = "extra_document";
    private static final String TAG = "LocalPolicyActivity";

    public static final void o(LocalPolicyActivity localPolicyActivity, View view) {
        localPolicyActivity.finish();
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        CharSequence string;
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_local_policy);
        ((ImageButton) findViewById(R$id.btn_back)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalPolicyActivity.o(this.f24809a, view);
            }
        });
        PolicyDocument policyDocumentFromName = PolicyDocument.INSTANCE.fromName(getIntent().getStringExtra(EXTRA_DOCUMENT));
        ((TextView) findViewById(R$id.tv_title)).setText(policyDocumentFromName.getTitleRes());
        TextView textView = (TextView) findViewById(R$id.tv_content);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String strP = p(policyDocumentFromName.getAssetName());
        if (strP == null || (string = q(strP)) == null) {
            string = getString(R$string.policy_load_failed);
            kotlin.jvm.internal.p.h(string, "getString(...)");
        }
        textView.setText(string);
    }

    public final String p(String name) {
        try {
            InputStream inputStreamOpen = getAssets().open(name);
            kotlin.jvm.internal.p.h(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
            try {
                String strE = l9.m.e(bufferedReader);
                l9.b.a(bufferedReader, null);
                return strE;
            } finally {
            }
        } catch (Throwable th) {
            C4148a.g(TAG, "policy asset missing: " + name, th, false, 8, null);
            return null;
        }
    }

    public final Spanned q(String html) {
        return Html.fromHtml(html, 63);
    }
}

package com.obric.privacyhook;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifeHookActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/obric/privacyhook/LifeHookActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "isPrivacyOk", "", "()Z", "onCreateWhenPrivacyNotOk", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntentWhenPrivacyNotOk", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onSuperCreate", "onSuperDestroy", "onSuperPause", "onSuperPostCreate", "onSuperPostResume", "onSuperResume", "onSuperStart", "onSuperStop", "superFinish", "superOnNewIntent", "superOnProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LifeHookActivity extends AppCompatActivity {
    public abstract boolean isPrivacyOk();

    public void onCreateWhenPrivacyNotOk(Bundle r1) {
    }

    public void onNewIntentWhenPrivacyNotOk(Intent r1) {
    }

    public LifeHookActivity() {
    }

    public final void onSuperCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onSuperPostCreate(Bundle r1) {
        super.onPostCreate(r1);
    }

    public final void onSuperStart() {
        super.onStart();
    }

    public final void onSuperResume() {
        super.onResume();
    }

    public final void onSuperPostResume() {
        super.onPostResume();
    }

    public final void onSuperPause() {
        super.onPause();
    }

    public final void onSuperStop() {
        super.onStop();
    }

    public final void onSuperDestroy() {
        super.onDestroy();
    }

    public final void superFinish() {
        super.finish();
    }

    public final void superOnNewIntent(Intent r1) {
        super.onNewIntent(r1);
    }

    public final void superOnProvideAssistContent(AssistContent r2) {
        Intrinsics.checkNotNullParameter(r2, "outContent");
        super.onProvideAssistContent(r2);
    }
}

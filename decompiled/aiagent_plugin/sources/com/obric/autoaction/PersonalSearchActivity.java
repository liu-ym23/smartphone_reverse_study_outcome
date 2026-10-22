package com.obric.autoaction;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.obric.autogui.common.api.logging.Loog;

/* JADX INFO: compiled from: PersonalSearchActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PersonalSearchActivity extends AppCompatActivity {
    public PersonalSearchActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        Loog.INSTANCE.e("PersonalSearchActivity", "onCreate --> NotSupported finish");
        finish();
    }
}

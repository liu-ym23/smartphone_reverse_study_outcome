package com.stepos.launcher.assistant.widgetstack.component;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.stepos.launcher.assistant.utils.Executors;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class SuggestionStateManager {
    private static final String CLS_SUGGESTION_PRIVACY = "com.stepos.suggestion.PrivacyPopupActivity";
    private static final String KEY_CTA = "cta";
    private static final String PKG_SUGGESTION = "com.stepos.suggestion";
    public static final String TAG = "SuggestionStateManager";
    private static final Uri URI_SUGGESTION_CTA = Uri.parse("content:// stepos.content.cta.app.suggestion");
    private boolean mIsSuggestionCtaAllowed = true;

    public static boolean getSuggestionCtaState(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(URI_SUGGESTION_CTA, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    i = cursorQuery.moveToFirst() ? cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("cta")) : -1;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            return i == 1;
        } catch (NullPointerException e10) {
            Log.e(TAG, "getSuggestionCtaState: ", e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSuggestionCtaAllowed$0(Consumer consumer) {
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(this.mIsSuggestionCtaAllowed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSuggestionCtaAllowed$1(Context context, final Consumer consumer) {
        boolean suggestionCtaState = getSuggestionCtaState(context);
        if (this.mIsSuggestionCtaAllowed != suggestionCtaState) {
            this.mIsSuggestionCtaAllowed = suggestionCtaState;
            Executors.MAIN_EXECUTOR.execute(new Runnable() { // from class: com.stepos.launcher.assistant.widgetstack.component.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30175a.lambda$updateSuggestionCtaAllowed$0(consumer);
                }
            });
        }
    }

    public static void startSuggestionCta(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.suggestion", CLS_SUGGESTION_PRIVACY));
            context.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public boolean isSuggestionCtaAllowed() {
        return this.mIsSuggestionCtaAllowed;
    }

    public void updateSuggestionCtaAllowed(Context context, final Consumer<Boolean> consumer) {
        final Context applicationContext = context.getApplicationContext();
        Executors.BACKGROUND_ABERRANT_EXECUTOR.execute(new Runnable() { // from class: com.stepos.launcher.assistant.widgetstack.component.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f30177a.lambda$updateSuggestionCtaAllowed$1(applicationContext, consumer);
            }
        });
    }
}

package stepai.aios.guiagent.llm.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lstepai/aios/guiagent/llm/config/PromptOverrideManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "", "modelCellType", "defaultPrompt", "getEffectivePrompt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", HighlightArgsBundle.KEY_PROMPT, "savePrompt", "(Ljava/lang/String;Ljava/lang/String;)V", "removeOverride", "(Ljava/lang/String;)V", "", "hasOverride", "(Ljava/lang/String;)Z", "getCustomPrompt", "(Ljava/lang/String;)Ljava/lang/String;", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "PREFS_NAME", "Ljava/lang/String;", "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/SharedPreferences;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromptOverrideManager {
    private static final String PREFS_NAME = "prompt_overrides";
    private static SharedPreferences prefs;
    public static final PromptOverrideManager INSTANCE = new PromptOverrideManager();
    private static boolean enabled = true;

    private PromptOverrideManager() {
    }

    public final String getCustomPrompt(String modelCellType) {
        k.f(modelCellType, "modelCellType");
        if (!enabled) {
            return null;
        }
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(modelCellType, null);
        }
        k.n("prefs");
        throw null;
    }

    public final String getEffectivePrompt(String modelCellType, String defaultPrompt) {
        k.f(modelCellType, "modelCellType");
        k.f(defaultPrompt, "defaultPrompt");
        if (enabled) {
            SharedPreferences sharedPreferences = prefs;
            if (sharedPreferences == null) {
                k.n("prefs");
                throw null;
            }
            String string = sharedPreferences.getString(modelCellType, null);
            if (string != null) {
                return string;
            }
        }
        return defaultPrompt;
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final boolean hasOverride(String modelCellType) {
        k.f(modelCellType, "modelCellType");
        if (!enabled) {
            return false;
        }
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(modelCellType);
        }
        k.n("prefs");
        throw null;
    }

    public final void init(Context context) {
        k.f(context, "context");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        k.e(sharedPreferences, "getSharedPreferences(...)");
        prefs = sharedPreferences;
    }

    public final void removeOverride(String modelCellType) {
        k.f(modelCellType, "modelCellType");
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(modelCellType).apply();
        } else {
            k.n("prefs");
            throw null;
        }
    }

    public final void savePrompt(String modelCellType, String prompt) {
        k.f(modelCellType, "modelCellType");
        k.f(prompt, "prompt");
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(modelCellType, prompt).apply();
        } else {
            k.n("prefs");
            throw null;
        }
    }

    public final void setEnabled(boolean z10) {
        enabled = z10;
    }
}

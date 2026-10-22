package com.stepos.aiengine.algorithm.highlight;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0018\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", "", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "", "a", "Ljava/lang/String;", "getVideoPath", "()Ljava/lang/String;", "videoPath", "b", "getPrompt", HighlightArgsBundle.KEY_PROMPT, "", "c", "I", "getVideoFilterFps", "()I", "videoFilterFps", "d", "getMaxTokens", "maxTokens", "Companion", "Builder", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HighlightArgsBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_PROMPT = "prompt";
    public static final String KEY_VIDEO_PATH = "video_path";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String videoPath;

    /* renamed from: b, reason: from kotlin metadata */
    public final String prompt;

    /* renamed from: c, reason: from kotlin metadata */
    public final int videoFilterFps;

    /* renamed from: d, reason: from kotlin metadata */
    public final int maxTokens;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Builder;", "", AppAgent.CONSTRUCT, "()V", "", SingleFileBundle.KEY_PATH, "videoPath", "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Builder;", "p", HighlightArgsBundle.KEY_PROMPT, "", "fps", "videoFilterFps", "(I)Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Builder;", "n", "maxTokens", "Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f3483a = "";
        public String b = "";
        public int c = 2;
        public int d = 256;

        public final HighlightArgsBundle build() {
            return new HighlightArgsBundle(this.f3483a, this.b, this.c, this.d, null);
        }

        public final Builder maxTokens(int n) {
            this.d = n;
            return this;
        }

        public final Builder prompt(String p) {
            k.f(p, "p");
            this.b = p;
            return this;
        }

        public final Builder videoFilterFps(int fps) {
            this.c = fps;
            return this;
        }

        public final Builder videoPath(String path) {
            k.f(path, "path");
            this.f3483a = path;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", TypedValues.TransitionType.S_FROM, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", "", "KEY_VIDEO_PATH", "Ljava/lang/String;", "KEY_PROMPT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final HighlightArgsBundle from(Bundle bundle) {
            k.f(bundle, "bundle");
            String string = bundle.getString(HighlightArgsBundle.KEY_VIDEO_PATH, "");
            k.e(string, "getString(...)");
            String string2 = bundle.getString(HighlightArgsBundle.KEY_PROMPT, "");
            k.e(string2, "getString(...)");
            return new HighlightArgsBundle(string, string2, bundle.getInt(HighlightCallback.ARG_VIDEO_FILTER_FPS, 2), bundle.getInt(HighlightCallback.ARG_MAX_TOKENS, 256), null);
        }
    }

    public HighlightArgsBundle(String str, String str2, int i, int i6, e eVar) {
        this.videoPath = str;
        this.prompt = str2;
        this.videoFilterFps = i;
        this.maxTokens = i6;
    }

    public final int getMaxTokens() {
        return this.maxTokens;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final int getVideoFilterFps() {
        return this.videoFilterFps;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_VIDEO_PATH, this.videoPath);
        bundle.putString(KEY_PROMPT, this.prompt);
        bundle.putInt(HighlightCallback.ARG_VIDEO_FILTER_FPS, this.videoFilterFps);
        bundle.putInt(HighlightCallback.ARG_MAX_TOKENS, this.maxTokens);
        return bundle;
    }
}

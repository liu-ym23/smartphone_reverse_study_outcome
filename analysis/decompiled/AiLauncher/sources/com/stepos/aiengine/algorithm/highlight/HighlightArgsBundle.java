package com.stepos.aiengine.algorithm.highlight;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.zyql.ai.selector.config.PictureConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u0019B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", "", "", PictureConfig.EXTRA_VIDEO_PATH, HighlightArgsBundle.KEY_PROMPT, "", "videoFilterFps", "maxTokens", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getVideoPath", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "getPrompt", "c", "I", "getVideoFilterFps", "()I", Const.INTENT_KEY_UMID, "getMaxTokens", "Companion", "Builder", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HighlightArgsBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_PROMPT = "prompt";
    public static final String KEY_VIDEO_PATH = "video_path";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String videoPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String prompt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int videoFilterFps;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int maxTokens;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Builder;", "", "<init>", "()V", "", "path", PictureConfig.EXTRA_VIDEO_PATH, "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Builder;", "p", HighlightArgsBundle.KEY_PROMPT, "", "fps", "videoFilterFps", "(I)Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Builder;", "n", "maxTokens", "Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "I", Const.INTENT_KEY_UMID, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public String videoPath = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public String prompt = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int videoFilterFps = 2;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int maxTokens = 256;

        public final HighlightArgsBundle build() {
            return new HighlightArgsBundle(this.videoPath, this.prompt, this.videoFilterFps, this.maxTokens, null);
        }

        public final Builder maxTokens(int n10) {
            this.maxTokens = n10;
            return this;
        }

        public final Builder prompt(String p10) {
            p.i(p10, "p");
            this.prompt = p10;
            return this;
        }

        public final Builder videoFilterFps(int fps) {
            this.videoFilterFps = fps;
            return this;
        }

        public final Builder videoPath(String path) {
            p.i(path, "path");
            this.videoPath = path;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle$Companion;", "", "<init>", "()V", "from", "Lcom/stepos/aiengine/algorithm/highlight/HighlightArgsBundle;", "bundle", "Landroid/os/Bundle;", "KEY_VIDEO_PATH", "", "KEY_PROMPT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final HighlightArgsBundle from(Bundle bundle) {
            p.i(bundle, "bundle");
            String string = bundle.getString(HighlightArgsBundle.KEY_VIDEO_PATH, "");
            p.h(string, "getString(...)");
            String string2 = bundle.getString(HighlightArgsBundle.KEY_PROMPT, "");
            p.h(string2, "getString(...)");
            return new HighlightArgsBundle(string, string2, bundle.getInt(HighlightCallback.ARG_VIDEO_FILTER_FPS, 2), bundle.getInt("max_new_tokens", 256), null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ HighlightArgsBundle(String str, String str2, int i10, int i11, i iVar) {
        this(str, str2, i10, i11);
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
        bundle.putInt("max_new_tokens", this.maxTokens);
        return bundle;
    }

    public HighlightArgsBundle(String str, String str2, int i10, int i11) {
        this.videoPath = str;
        this.prompt = str2;
        this.videoFilterFps = i10;
        this.maxTokens = i11;
    }
}

package com.stepos.ailauncher.taskstore.widget;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"PREVIEW_CROSSFADE_MS", "", "PREVIEWABLE_EXTS", "", "", "PREVIEWABLE_MIMES", "CODE_CARD_EXTS", "CODE_CARD_MIMES", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class W {
    private static final int PREVIEW_CROSSFADE_MS = 220;
    private static final Set<String> PREVIEWABLE_EXTS = Z8.Y.j(ChatTracker.CONTENT_PPT, "pptx");
    private static final Set<String> PREVIEWABLE_MIMES = Z8.Y.j("application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
    private static final Set<String> CODE_CARD_EXTS = Z8.Y.j("js", "ts", "py", "java", "go", "css", "json");
    private static final Set<String> CODE_CARD_MIMES = Z8.Y.j("text/css", "text/javascript", "application/javascript", "text/x-python", "text/x-java", "text/x-go", "application/json");
}

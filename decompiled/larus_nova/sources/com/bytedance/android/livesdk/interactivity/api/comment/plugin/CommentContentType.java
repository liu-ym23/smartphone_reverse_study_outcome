package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentContentType;", "", "Text", "Image", "RichText", ServiceType.AUDIO, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentContentType extends Enum<CommentContentType> {
    public static final CommentContentType Audio = null;
    public static final CommentContentType Image = null;
    public static final CommentContentType RichText = null;
    public static final CommentContentType Text = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentContentType[] f133046a = null;

    static {
        CommentContentType r100 = new CommentContentType("Text", 0);
        Text = r100;
        CommentContentType r101 = new CommentContentType("Image", 1);
        Image = r101;
        CommentContentType r102 = new CommentContentType("RichText", 2);
        RichText = r102;
        CommentContentType r103 = new CommentContentType(ServiceType.AUDIO, 3);
        Audio = r103;
        f133046a = new CommentContentType[]{r100, r101, r102, r103};
    }

    public static CommentContentType valueOf(String r100) {
        return (CommentContentType) a.a(CommentContentType.class, r100);
    }

    public static CommentContentType[] values() {
        return (CommentContentType[]) f133046a.clone();
    }

    public CommentContentType(String r100, int r101) {
        super(r100, r101);
    }
}

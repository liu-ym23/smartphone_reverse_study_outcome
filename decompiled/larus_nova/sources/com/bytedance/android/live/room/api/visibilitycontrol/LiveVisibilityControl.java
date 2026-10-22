package com.bytedance.android.live.room.api.visibilitycontrol;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes47.dex */
@Target({ElementType.TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000bR\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\u000eR\u000f\u0010\f\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\f\u0010\u000fR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0010R\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000fR\u000f\u0010\r\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl;", "", "key", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$KEY;", "type", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Type;", "style", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Style;", "attachMarginDp", "", "needDynamicControl", "", "ignoreLock", "reverse", "()F", "()Z", "()Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$KEY;", "()Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Style;", "()Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Type;", "KEY", "Style", "Type", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface LiveVisibilityControl {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$KEY;", "", "", "describe", "Ljava/lang/String;", "getDescribe", "()Ljava/lang/String;", "LivePlayControl", "LiveProgressBar", "LiveThumb", "LandscapeBlockComment", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum KEY extends Enum<KEY> {
        public static final KEY LandscapeBlockComment = null;
        public static final KEY LivePlayControl = null;
        public static final KEY LiveProgressBar = null;
        public static final KEY LiveThumb = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KEY[] f99160a = null;
        private final String describe;

        static {
            KEY r100 = new KEY("LivePlayControl", 0, "普通直播间播放、暂停按钮");
            LivePlayControl = r100;
            KEY r101 = new KEY("LiveProgressBar", 1, "普通直播间进度条");
            LiveProgressBar = r101;
            KEY r102 = new KEY("LiveThumb", 2, "普通直播间拖动进度条时的遮罩层");
            LiveThumb = r102;
            KEY r103 = new KEY("LandscapeBlockComment", 3, "媒体节目融合直播间屏蔽按钮");
            LandscapeBlockComment = r103;
            f99160a = new KEY[]{r100, r101, r102, r103};
        }

        public static KEY valueOf(String r100) {
            return (KEY) r27.a.a(KEY.class, r100);
        }

        public static KEY[] values() {
            return (KEY[]) f99160a.clone();
        }

        public final String getDescribe() {
            return this.describe;
        }

        public KEY(String r100, int r101, String r102) {
            super(r100, r101);
            this.describe = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Style;", "", "HIDE", "ATTACH", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style ATTACH = null;
        public static final Style HIDE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f99161a = null;

        static {
            Style r100 = new Style("HIDE", 0);
            HIDE = r100;
            Style r101 = new Style("ATTACH", 1);
            ATTACH = r101;
            f99161a = new Style[]{r100, r101};
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) f99161a.clone();
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Type;", "", "TOP", "BOTTOM", "LEFT", "RIGHT", UserProfileEvent.POSITION_NONE, "ALPHA", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALPHA = null;
        public static final Type BOTTOM = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f99162a = null;

        static {
            Type r100 = new Type("TOP", 0);
            TOP = r100;
            Type r101 = new Type("BOTTOM", 1);
            BOTTOM = r101;
            Type r102 = new Type("LEFT", 2);
            LEFT = r102;
            Type r103 = new Type("RIGHT", 3);
            RIGHT = r103;
            Type r104 = new Type(UserProfileEvent.POSITION_NONE, 4);
            NONE = r104;
            Type r105 = new Type("ALPHA", 5);
            ALPHA = r105;
            f99162a = new Type[]{r100, r101, r102, r103, r104, r105};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f99162a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    float attachMarginDp() default 0.0f;

    boolean ignoreLock() default false;

    KEY key();

    boolean needDynamicControl() default false;

    boolean reverse() default false;

    Style style() default Style.HIDE;

    Type type();
}

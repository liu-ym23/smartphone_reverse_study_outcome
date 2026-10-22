package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\f\rB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bR\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayDoubleCheckResultEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "scene", "Lcom/android/ttcjpaysdk/base/framework/event/CJPayDoubleCheckResultEvent$Scene;", "status", "Lcom/android/ttcjpaysdk/base/framework/event/CJPayDoubleCheckResultEvent$Status;", "jsonObject", "Lorg/json/JSONObject;", "curVerifyProduct", "", "ext", "(Lcom/android/ttcjpaysdk/base/framework/event/CJPayDoubleCheckResultEvent$Scene;Lcom/android/ttcjpaysdk/base/framework/event/CJPayDoubleCheckResultEvent$Status;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "Scene", "Status", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDoubleCheckResultEvent extends BaseEvent {
    public String curVerifyProduct;
    public String ext;
    public JSONObject jsonObject;
    public Scene scene;
    public Status status;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayDoubleCheckResultEvent$Scene;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "SDK", "Lynx", "None", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final Scene Lynx = null;
        public static final Scene None = null;
        public static final Scene SDK = null;
        private final String code;

        private static final /* synthetic */ Scene[] $values() {
            return new Scene[]{SDK, Lynx, None};
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        static {
            SDK = new Scene("SDK", 0, "0");
            Lynx = new Scene("Lynx", 1, "1");
            None = new Scene("None", 2, "2");
            $VALUES = $values();
        }

        public final String getCode() {
            return this.code;
        }

        private Scene(String r100, int r101, String r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayDoubleCheckResultEvent$Status;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Cancel", "Success", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status Cancel = null;
        public static final Status Success = null;
        private final String code;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Cancel, Success};
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            Cancel = new Status("Cancel", 0, "0");
            Success = new Status("Success", 1, "1");
            $VALUES = $values();
        }

        public final String getCode() {
            return this.code;
        }

        private Status(String r100, int r101, String r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public CJPayDoubleCheckResultEvent(Scene r100, Status r101, JSONObject r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "status");
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        this.scene = r100;
        this.status = r101;
        this.jsonObject = r102;
        this.curVerifyProduct = r103;
        this.ext = r104;
    }

    public /* synthetic */ CJPayDoubleCheckResultEvent(Scene r100, Status r101, JSONObject r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r102 = new JSONObject();
    L5:
        JSONObject r103 = r102;
        if ((r112 & 8) == 0) goto L8;
        String r104 = "";
    L10:
        if ((r112 & 16) == 0) goto L12;
        String r105 = "";
    L13:
        this(r100, r101, r103, r104, r105);
        return;
    L12:
        r105 = r111;
        goto L13
    L8:
        r104 = r110;
        goto L10
    }
}

package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ActionContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ActionContext implements Parcelable {
    public static final CREATOR CREATOR = null;

    /* JADX INFO: compiled from: ActionContext.kt */
    public static final class CREATOR implements Parcelable.Creator<ActionContext> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionContext createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActionContext[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionContext createFromParcel(Parcel r3) {
            o.e(r3, DBHelper.BATTERY_COL_SOURCE);
            int r2 = r3.readInt();
            if (r2 == 1) goto L18;
            if (r2 == 2) goto L23;
            if (r2 == 3) goto L22;
            if (r2 == 4) goto L21;
            if (r2 == 5) goto L20;
            return null;
        L20:
            return (ActionContext) ZeusTransformUtils.preCheckCast(VideoActionContext.CREATOR.createFromParcel(r3), ActionContext.class, "com.obric.aiagent.plugin");
        L21:
            return (ActionContext) ZeusTransformUtils.preCheckCast(IMActionContext.CREATOR.createFromParcel(r3), ActionContext.class, "com.obric.aiagent.plugin");
        L22:
            return (ActionContext) ZeusTransformUtils.preCheckCast(WebsiteActionContext.CREATOR.createFromParcel(r3), ActionContext.class, "com.obric.aiagent.plugin");
        L23:
            return (ActionContext) ZeusTransformUtils.preCheckCast(FileActionContext.CREATOR.createFromParcel(r3), ActionContext.class, "com.obric.aiagent.plugin");
        L18:
            return (ActionContext) ZeusTransformUtils.preCheckCast(PhotoActionContext.CREATOR.createFromParcel(r3), ActionContext.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionContext[] newArray(int r1) {
            return new ActionContext[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getActivityName();

    public abstract String getPackageName();

    public abstract int getType();

    public ActionContext() {
    }

    public final void writeToParcelBase(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(getType());
    }
}

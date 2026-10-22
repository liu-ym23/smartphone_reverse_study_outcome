package android.net.ipmemorystore;

/* JADX INFO: loaded from: classes.dex */
public class Status {
    public static final int ERROR_DATABASE_CANNOT_BE_OPENED = -3;
    public static final int ERROR_GENERIC = -1;
    public static final int ERROR_ILLEGAL_ARGUMENT = -2;
    public static final int ERROR_STORAGE = -4;
    public static final int ERROR_UNKNOWN = -5;
    public static final int SUCCESS = 0;
    public final int resultCode;

    public Status(int resultCode) {
        this.resultCode = resultCode;
    }

    public Status(StatusParcelable parcelable) {
        this(parcelable.resultCode);
    }

    public StatusParcelable toParcelable() {
        StatusParcelable parcelable = new StatusParcelable();
        parcelable.resultCode = this.resultCode;
        return parcelable;
    }

    public boolean isSuccess() {
        if (this.resultCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        switch(this.resultCode) {
            case -4: goto L14;
            case -3: goto L12;
            case -2: goto L10;
            case -1: goto L8;
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "Unknown value ?!";
    L6:
        return "SUCCESS";
    L8:
        return "GENERIC ERROR";
    L10:
        return "ILLEGAL ARGUMENT";
    L12:
        return "DATABASE CANNOT BE OPENED";
    L14:
        return "DATABASE STORAGE ERROR";
    }
}

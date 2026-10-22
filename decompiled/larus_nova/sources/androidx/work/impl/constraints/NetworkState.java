package androidx.work.impl.constraints;

/* JADX INFO: loaded from: classes17.dex */
public class NetworkState {
    private boolean mIsConnected;
    private boolean mIsMetered;
    private boolean mIsNotRoaming;
    private boolean mIsValidated;

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.mIsConnected), Boolean.valueOf(this.mIsValidated), Boolean.valueOf(this.mIsMetered), Boolean.valueOf(this.mIsNotRoaming)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r100 = this.mIsConnected;
        int r101 = r100;
        if (this.mIsValidated == false) goto L5;
        r101 = r100 + 16;
    L5:
        int r102 = r101;
        if (this.mIsMetered == false) goto L9;
        r102 = r101 + 256;
    L9:
        if (this.mIsNotRoaming == true) goto L11;
        return r102;
    L11:
        return r102 + 4096;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isMetered() {
        return this.mIsMetered;
    }

    public boolean isNotRoaming() {
        return this.mIsNotRoaming;
    }

    public boolean isValidated() {
        return this.mIsValidated;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NetworkState) == true) goto L8;
        return false;
    L8:
        NetworkState r101 = (NetworkState) r100;
        if (this.mIsConnected == r101.mIsConnected) goto L11;
    L17:
        return false;
    L11:
        if (this.mIsValidated != r101.mIsValidated) goto L17;
        if (this.mIsMetered != r101.mIsMetered) goto L17;
        if (this.mIsNotRoaming != r101.mIsNotRoaming) goto L17;
        return true;
    }

    public NetworkState(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.mIsConnected = r100;
        this.mIsValidated = r101;
        this.mIsMetered = r102;
        this.mIsNotRoaming = r103;
    }
}

package android.net;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.android.modules.utils.build.SdkLevel;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class NetworkFactory {
    public static final int CMD_CANCEL_REQUEST = 2;
    public static final int CMD_REQUEST_NETWORK = 1;
    static final boolean DBG = true;
    static final boolean VDBG = false;
    private final String LOG_TAG;
    final NetworkFactoryShim mImpl;
    private int mRefCount;

    public NetworkFactory(Looper looper, Context context, String logTag, NetworkCapabilities filter) {
        this.mRefCount = 0;
        this.LOG_TAG = logTag;
        if (SdkLevel.isAtLeastS() == false) goto L5;
        this.mImpl = new NetworkFactoryImpl(this, looper, context, filter);
        return;
    L5:
        this.mImpl = new NetworkFactoryLegacyImpl(this, looper, context, filter);
    }

    public Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        return this.mImpl.obtainMessage(what, arg1, arg2, obj);
    }

    public final Looper getLooper() {
        return this.mImpl.getLooper();
    }

    public void register() {
        this.mImpl.register(this.LOG_TAG);
    }

    public void registerIgnoringScore() {
        this.mImpl.registerIgnoringScore(this.LOG_TAG);
    }

    public void terminate() {
        this.mImpl.terminate();
    }

    protected final void reevaluateAllRequests() {
        this.mImpl.reevaluateAllRequests();
    }

    public boolean acceptRequest(NetworkRequest request) {
        return true;
    }

    protected void releaseRequestAsUnfulfillableByAnyFactory(NetworkRequest r) {
        this.mImpl.releaseRequestAsUnfulfillableByAnyFactory(r);
    }

    protected void startNetwork() {
    }

    protected void stopNetwork() {
    }

    protected void needNetworkFor(NetworkRequest networkRequest) {
        int r0 = this.mRefCount + 1;
        this.mRefCount = r0;
        if (r0 != 1) goto L6;
        startNetwork();
        return;
    }

    protected void releaseNetworkFor(NetworkRequest networkRequest) {
        int r0 = this.mRefCount - 1;
        this.mRefCount = r0;
        if (r0 != 0) goto L6;
        stopNetwork();
        return;
    }

    @Deprecated
    public void setScoreFilter(int score) {
        this.mImpl.setScoreFilter(score);
    }

    public void setScoreFilter(NetworkScore score) {
        this.mImpl.setScoreFilter(score);
    }

    public void setCapabilityFilter(NetworkCapabilities netCap) {
        this.mImpl.setCapabilityFilter(netCap);
    }

    protected int getRequestCount() {
        return this.mImpl.getRequestCount();
    }

    public int getSerialNumber() {
        return this.mImpl.getSerialNumber();
    }

    public NetworkProvider getProvider() {
        return this.mImpl.getProvider();
    }

    protected void log(String s) {
        Log.d(this.LOG_TAG, s);
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        this.mImpl.dump(fd, writer, args);
    }

    public String toString() {
        return "{" + this.LOG_TAG + " " + this.mImpl.toString() + "}";
    }
}

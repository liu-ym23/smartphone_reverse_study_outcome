package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.DebugUtils;
import com.alipay.sdk.m.u.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes17.dex */
public class Loader<D> {
    boolean mAbandoned;
    boolean mContentChanged;
    Context mContext;
    int mId;
    OnLoadCompleteListener<D> mListener;
    OnLoadCanceledListener<D> mOnLoadCanceledListener;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;

    public final class ForceLoadContentObserver extends ContentObserver {
        final /* synthetic */ Loader this$0;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        public ForceLoadContentObserver(Loader r100) {
            this.this$0 = r100;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r100) {
            this.this$0.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> r100);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> r100, D r101);
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public void onAbandon() {
    }

    public boolean onCancelLoad() {
        return false;
    }

    public void onForceLoad() {
    }

    public void onReset() {
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public void deliverCancellation() {
        OnLoadCanceledListener<D> r100 = this.mOnLoadCanceledListener;
        if (r100 == null) goto L6;
        r100.onLoadCanceled(this);
        return;
    }

    public void onContentChanged() {
        if (this.mStarted == false) goto L5;
        forceLoad();
        return;
    L5:
        this.mContentChanged = true;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange == false) goto L6;
        onContentChanged();
        return;
    }

    public boolean takeContentChanged() {
        boolean r100 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= r100;
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, r100);
        r100.append(" id=");
        r100.append(this.mId);
        r100.append(i.f25855d);
        return r100.toString();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public Loader(Context r100) {
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = r100.getApplicationContext();
    }

    public String dataToString(D r100) {
        StringBuilder r101 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(r100, r101);
        r101.append(i.f25855d);
        return r101.toString();
    }

    public void deliverResult(D r100) {
        OnLoadCompleteListener<D> r101 = this.mListener;
        if (r101 == null) goto L6;
        r101.onLoadComplete(this, r100);
        return;
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> r100) {
        if (this.mOnLoadCanceledListener != null) goto L7;
        this.mOnLoadCanceledListener = r100;
        return;
    L7:
        throw new IllegalStateException("There is already a listener registered");
    }

    public void unregisterListener(OnLoadCompleteListener<D> r100) {
        OnLoadCompleteListener<D> r101 = this.mListener;
        if (r101 == null) goto L10;
        if (r101 != r100) goto L8;
        this.mListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> r100) {
        OnLoadCanceledListener<D> r101 = this.mOnLoadCanceledListener;
        if (r101 == null) goto L10;
        if (r101 != r100) goto L8;
        this.mOnLoadCanceledListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }

    public void registerListener(int r100, OnLoadCompleteListener<D> r101) {
        if (this.mListener != null) goto L7;
        this.mListener = r101;
        this.mId = r100;
        return;
    L7:
        throw new IllegalStateException("There is already a listener registered");
    }

    public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        r102.print(r100);
        r102.print("mId=");
        r102.print(this.mId);
        r102.print(" mListener=");
        r102.println(this.mListener);
        if (this.mStarted == false) goto L5;
    L8:
        r102.print(r100);
        r102.print("mStarted=");
        r102.print(this.mStarted);
        r102.print(" mContentChanged=");
        r102.print(this.mContentChanged);
        r102.print(" mProcessingChange=");
        r102.println(this.mProcessingChange);
    L10:
        if (this.mAbandoned == false) goto L12;
    L13:
        r102.print(r100);
        r102.print("mAbandoned=");
        r102.print(this.mAbandoned);
        r102.print(" mReset=");
        r102.println(this.mReset);
        return;
    L12:
        if (this.mReset == true) goto L13;
        return;
    L5:
        if (this.mContentChanged == true) goto L8;
        if (this.mProcessingChange == false) goto L10;
        goto L8
    }
}

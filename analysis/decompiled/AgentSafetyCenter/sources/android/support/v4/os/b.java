package android.support.v4.os;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.IResultReceiver;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a(0);

    /* renamed from: c, reason: collision with root package name */
    public IResultReceiver f648c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.f648c == null) {
                    this.f648c = new IResultReceiver.Stub() { // from class: android.support.v4.os.ResultReceiver$MyResultReceiver
                        @Override // android.support.v4.os.IResultReceiver
                        public void send(int i3, Bundle bundle) {
                            this.this$0.getClass();
                            this.this$0.getClass();
                        }
                    };
                }
                parcel.writeStrongBinder(this.f648c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

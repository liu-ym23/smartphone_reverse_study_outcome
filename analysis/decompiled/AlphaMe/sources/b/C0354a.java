package b;

import B0.f;
import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.WakeLockData;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableByte;
import androidx.databinding.ObservableChar;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableLong;
import androidx.databinding.ObservableParcelable;
import androidx.databinding.ObservableShort;
import androidx.navigation.NavBackStackEntryState;
import androidx.versionedparcelable.ParcelImpl;
import b.C0354a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import t0.J;

/* renamed from: b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0354a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4351a;

    public /* synthetic */ C0354a(int i4) {
        this.f4351a = i4;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Uri uri;
        Bundle bundle;
        int iO0 = 0;
        Bundle bundleK = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String strQ = null;
        ArrayList<GoogleSignInOptionsExtensionParcelable> arrayListS = null;
        switch (this.f4351a) {
            case 0:
                return new WakeLockData(parcel);
            case 1:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new C0354a(1);

                    /* renamed from: a, reason: collision with root package name */
                    public final int f2324a;

                    /* renamed from: b, reason: collision with root package name */
                    public final MediaDescriptionCompat f2325b;

                    @Retention(RetentionPolicy.SOURCE)
                    @RestrictTo({EnumC0546d.f12493b})
                    public @interface Flags {
                    }

                    {
                        this.f2324a = parcel.readInt();
                        this.f2325b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f2324a + ", mDescription=" + this.f2325b + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i4) {
                        parcel2.writeInt(this.f2324a);
                        this.f2325b.writeToParcel(parcel2, i4);
                    }
                };
            case 2:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String mediaId = mediaDescription.getMediaId();
                CharSequence title = mediaDescription.getTitle();
                CharSequence subtitle = mediaDescription.getSubtitle();
                CharSequence description = mediaDescription.getDescription();
                Bitmap iconBitmap = mediaDescription.getIconBitmap();
                Uri iconUri = mediaDescription.getIconUri();
                Bundle extras = mediaDescription.getExtras();
                if (extras != null) {
                    extras.setClassLoader(J.class.getClassLoader());
                    uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                } else {
                    uri = null;
                }
                if (uri == null) {
                    bundle = extras;
                } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                    bundle = null;
                } else {
                    extras.remove("android.support.v4.media.description.MEDIA_URI");
                    extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = extras;
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, uri != null ? uri : mediaDescription.getMediaUri());
                mediaDescriptionCompat.f2334i = objCreateFromParcel;
                return mediaDescriptionCompat;
            case 3:
                return new MediaMetadataCompat(parcel);
            case 4:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 5:
                return new MediaSessionCompat$QueueItem(parcel);
            case 6:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f2340a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 7:
                final Parcelable parcelable = parcel.readParcelable(null);
                return new Parcelable(parcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new C0354a(7);

                    /* renamed from: a, reason: collision with root package name */
                    public final Object f2341a;

                    {
                        this.f2341a = parcelable;
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MediaSessionCompat$Token)) {
                            return false;
                        }
                        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
                        Object obj2 = this.f2341a;
                        if (obj2 == null) {
                            return mediaSessionCompat$Token.f2341a == null;
                        }
                        Object obj3 = mediaSessionCompat$Token.f2341a;
                        if (obj3 == null) {
                            return false;
                        }
                        return obj2.equals(obj3);
                    }

                    public final int hashCode() {
                        Object obj = this.f2341a;
                        if (obj == null) {
                            return 0;
                        }
                        return obj.hashCode();
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i4) {
                        parcel2.writeParcelable((Parcelable) this.f2341a, i4);
                    }
                };
            case 8:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f2342a = parcel.readInt();
                parcelableVolumeInfo.f2344c = parcel.readInt();
                parcelableVolumeInfo.f2345d = parcel.readInt();
                parcelableVolumeInfo.f2346e = parcel.readInt();
                parcelableVolumeInfo.f2343b = parcel.readInt();
                return parcelableVolumeInfo;
            case 9:
                return new PlaybackStateCompat(parcel);
            case 10:
                return new android.support.v4.os.ResultReceiver(parcel);
            case 11:
                return new ActivityResult(parcel);
            case 12:
                Intrinsics.checkNotNullParameter(parcel, "inParcel");
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Parcelable parcelable2 = parcel.readParcelable(IntentSender.class.getClassLoader());
                Intrinsics.checkNotNull(parcelable2);
                return new IntentSenderRequest((IntentSender) parcelable2, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 13:
                boolean z4 = parcel.readInt() == 1;
                ObservableBoolean observableBoolean = new ObservableBoolean();
                observableBoolean.f3386i = z4;
                return observableBoolean;
            case 14:
                byte b4 = parcel.readByte();
                ObservableByte observableByte = new ObservableByte();
                observableByte.f3387i = b4;
                return observableByte;
            case 15:
                char c4 = (char) parcel.readInt();
                ObservableChar observableChar = new ObservableChar();
                observableChar.f3388i = c4;
                return observableChar;
            case 16:
                double d4 = parcel.readDouble();
                ObservableDouble observableDouble = new ObservableDouble();
                observableDouble.f3389i = d4;
                return observableDouble;
            case 17:
                float f4 = parcel.readFloat();
                ObservableFloat observableFloat = new ObservableFloat();
                observableFloat.f3390i = f4;
                return observableFloat;
            case 18:
                int i4 = parcel.readInt();
                ObservableInt observableInt = new ObservableInt();
                observableInt.f3391i = i4;
                return observableInt;
            case 19:
                long j4 = parcel.readLong();
                ObservableLong observableLong = new ObservableLong();
                observableLong.f3392i = j4;
                return observableLong;
            case 20:
                Parcelable parcelable3 = parcel.readParcelable(C0354a.class.getClassLoader());
                ObservableParcelable observableParcelable = new ObservableParcelable();
                observableParcelable.f1658i = parcelable3;
                return observableParcelable;
            case 21:
                short s4 = (short) parcel.readInt();
                ObservableShort observableShort = new ObservableShort();
                observableShort.f3393i = s4;
                return observableShort;
            case 22:
                Intrinsics.checkNotNullParameter(parcel, "inParcel");
                return new NavBackStackEntryState(parcel);
            case 23:
                return new ParcelImpl(parcel);
            case 24:
                int iD0 = f.D0(parcel);
                int iO02 = 0;
                while (parcel.dataPosition() < iD0) {
                    int i5 = parcel.readInt();
                    char c5 = (char) i5;
                    if (c5 == 1) {
                        iO0 = f.o0(parcel, i5);
                    } else if (c5 == 2) {
                        iO02 = f.o0(parcel, i5);
                    } else if (c5 != 3) {
                        f.z0(parcel, i5);
                    } else {
                        bundleK = f.k(parcel, i5);
                    }
                }
                f.t(parcel, iD0);
                return new GoogleSignInOptionsExtensionParcelable(iO0, iO02, bundleK);
            case 25:
                int iD02 = f.D0(parcel);
                long jP0 = 0;
                int iO03 = 0;
                String strQ2 = null;
                String strQ3 = null;
                String strQ4 = null;
                String strQ5 = null;
                Uri uri2 = null;
                String strQ6 = null;
                String strQ7 = null;
                ArrayList arrayListS2 = null;
                String strQ8 = null;
                String strQ9 = null;
                while (parcel.dataPosition() < iD02) {
                    int i6 = parcel.readInt();
                    switch ((char) i6) {
                        case 1:
                            iO03 = f.o0(parcel, i6);
                            break;
                        case 2:
                            strQ2 = f.q(parcel, i6);
                            break;
                        case 3:
                            strQ3 = f.q(parcel, i6);
                            break;
                        case 4:
                            strQ4 = f.q(parcel, i6);
                            break;
                        case 5:
                            strQ5 = f.q(parcel, i6);
                            break;
                        case 6:
                            uri2 = (Uri) f.p(parcel, i6, Uri.CREATOR);
                            break;
                        case 7:
                            strQ6 = f.q(parcel, i6);
                            break;
                        case '\b':
                            jP0 = f.p0(parcel, i6);
                            break;
                        case '\t':
                            strQ7 = f.q(parcel, i6);
                            break;
                        case '\n':
                            arrayListS2 = f.s(parcel, i6, Scope.CREATOR);
                            break;
                        case 11:
                            strQ8 = f.q(parcel, i6);
                            break;
                        case '\f':
                            strQ9 = f.q(parcel, i6);
                            break;
                        default:
                            f.z0(parcel, i6);
                            break;
                    }
                }
                f.t(parcel, iD02);
                return new GoogleSignInAccount(iO03, strQ2, strQ3, strQ4, strQ5, uri2, strQ6, jP0, strQ7, arrayListS2, strQ8, strQ9);
            case 26:
                int iD03 = f.D0(parcel);
                int iO04 = 0;
                boolean zI0 = false;
                boolean zI02 = false;
                boolean zI03 = false;
                ArrayList arrayListS3 = null;
                Account account = null;
                String strQ10 = null;
                String strQ11 = null;
                String strQ12 = null;
                while (parcel.dataPosition() < iD03) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 1:
                            iO04 = f.o0(parcel, i7);
                            break;
                        case 2:
                            arrayListS3 = f.s(parcel, i7, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) f.p(parcel, i7, Account.CREATOR);
                            break;
                        case 4:
                            zI0 = f.i0(parcel, i7);
                            break;
                        case 5:
                            zI02 = f.i0(parcel, i7);
                            break;
                        case 6:
                            zI03 = f.i0(parcel, i7);
                            break;
                        case 7:
                            strQ10 = f.q(parcel, i7);
                            break;
                        case '\b':
                            strQ11 = f.q(parcel, i7);
                            break;
                        case '\t':
                            arrayListS = f.s(parcel, i7, GoogleSignInOptionsExtensionParcelable.CREATOR);
                            break;
                        case '\n':
                            strQ12 = f.q(parcel, i7);
                            break;
                        default:
                            f.z0(parcel, i7);
                            break;
                    }
                }
                f.t(parcel, iD03);
                HashMap map = new HashMap();
                if (arrayListS != null) {
                    for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : arrayListS) {
                        map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.f9594b), googleSignInOptionsExtensionParcelable);
                    }
                }
                return new GoogleSignInOptions(iO04, arrayListS3, account, zI0, zI02, zI03, strQ10, strQ11, map, strQ12);
            case 27:
                int iD04 = f.D0(parcel);
                while (parcel.dataPosition() < iD04) {
                    int i8 = parcel.readInt();
                    char c6 = (char) i8;
                    if (c6 == 1) {
                        iO0 = f.o0(parcel, i8);
                    } else if (c6 != 2) {
                        f.z0(parcel, i8);
                    } else {
                        strQ = f.q(parcel, i8);
                    }
                }
                f.t(parcel, iD04);
                return new Scope(iO0, strQ);
            case 28:
                int iD05 = f.D0(parcel);
                int iO05 = 0;
                int iO06 = 0;
                String strQ13 = null;
                PendingIntent pendingIntent = null;
                ConnectionResult connectionResult = null;
                while (parcel.dataPosition() < iD05) {
                    int i9 = parcel.readInt();
                    char c7 = (char) i9;
                    if (c7 == 1) {
                        iO06 = f.o0(parcel, i9);
                    } else if (c7 == 2) {
                        strQ13 = f.q(parcel, i9);
                    } else if (c7 == 3) {
                        pendingIntent = (PendingIntent) f.p(parcel, i9, PendingIntent.CREATOR);
                    } else if (c7 == 4) {
                        connectionResult = (ConnectionResult) f.p(parcel, i9, ConnectionResult.CREATOR);
                    } else if (c7 != 1000) {
                        f.z0(parcel, i9);
                    } else {
                        iO05 = f.o0(parcel, i9);
                    }
                }
                f.t(parcel, iD05);
                return new Status(iO05, iO06, strQ13, pendingIntent, connectionResult);
            default:
                int iD06 = f.D0(parcel);
                int iO07 = 0;
                while (parcel.dataPosition() < iD06) {
                    int i10 = parcel.readInt();
                    char c8 = (char) i10;
                    if (c8 == 1) {
                        iO0 = f.o0(parcel, i10);
                    } else if (c8 == 2) {
                        parcelFileDescriptor = (ParcelFileDescriptor) f.p(parcel, i10, ParcelFileDescriptor.CREATOR);
                    } else if (c8 != 3) {
                        f.z0(parcel, i10);
                    } else {
                        iO07 = f.o0(parcel, i10);
                    }
                }
                f.t(parcel, iD06);
                return new BitmapTeleporter(iO0, parcelFileDescriptor, iO07);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f4351a) {
            case 0:
                return new WakeLockData[i4];
            case 1:
                return new MediaBrowserCompat$MediaItem[i4];
            case 2:
                return new MediaDescriptionCompat[i4];
            case 3:
                return new MediaMetadataCompat[i4];
            case 4:
                return new RatingCompat[i4];
            case 5:
                return new MediaSessionCompat$QueueItem[i4];
            case 6:
                return new MediaSessionCompat$ResultReceiverWrapper[i4];
            case 7:
                return new MediaSessionCompat$Token[i4];
            case 8:
                return new ParcelableVolumeInfo[i4];
            case 9:
                return new PlaybackStateCompat[i4];
            case 10:
                return new android.support.v4.os.ResultReceiver[i4];
            case 11:
                return new ActivityResult[i4];
            case 12:
                return new IntentSenderRequest[i4];
            case 13:
                return new ObservableBoolean[i4];
            case 14:
                return new ObservableByte[i4];
            case 15:
                return new ObservableChar[i4];
            case 16:
                return new ObservableDouble[i4];
            case 17:
                return new ObservableFloat[i4];
            case 18:
                return new ObservableInt[i4];
            case 19:
                return new ObservableLong[i4];
            case 20:
                return new ObservableParcelable[i4];
            case 21:
                return new ObservableShort[i4];
            case 22:
                return new NavBackStackEntryState[i4];
            case 23:
                return new ParcelImpl[i4];
            case 24:
                return new GoogleSignInOptionsExtensionParcelable[i4];
            case 25:
                return new GoogleSignInAccount[i4];
            case 26:
                return new GoogleSignInOptions[i4];
            case 27:
                return new Scope[i4];
            case 28:
                return new Status[i4];
            default:
                return new BitmapTeleporter[i4];
        }
    }
}

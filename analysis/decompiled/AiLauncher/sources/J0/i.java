package J0;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001b\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"LJ0/i;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/io/InputStream;", "input", Const.INTENT_KEY_APIKEY, "(Ljava/io/InputStream;Le9/c;)Ljava/lang/Object;", "t", "Ljava/io/OutputStream;", "output", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Ljava/io/OutputStream;Le9/c;)Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "defaultValue", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public interface i<T> {
    Object a(InputStream inputStream, InterfaceC4014c<? super T> interfaceC4014c);

    Object b(T t10, OutputStream outputStream, InterfaceC4014c<? super t> interfaceC4014c);

    T getDefaultValue();
}

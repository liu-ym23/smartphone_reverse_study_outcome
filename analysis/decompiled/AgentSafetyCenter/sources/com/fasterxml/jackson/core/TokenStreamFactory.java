package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.DataOutputAsStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.net.URL;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class TokenStreamFactory implements Versioned, Serializable {
    private static final long serialVersionUID = 2;

    public void _checkRangeBoundsForByteArray(byte[] bArr, int i, int i3) {
        if (bArr == null) {
            _reportRangeError("Invalid `byte[]` argument: `null`");
        }
        int length = bArr.length;
        int i10 = i + i3;
        if (((length - i10) | i | i3 | i10) < 0) {
            _reportRangeError(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `byte[]` of length %d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(length)));
        }
    }

    public void _checkRangeBoundsForCharArray(char[] cArr, int i, int i3) {
        if (cArr == null) {
            _reportRangeError("Invalid `char[]` argument: `null`");
        }
        int length = cArr.length;
        int i10 = i + i3;
        if (((length - i10) | i | i3 | i10) < 0) {
            _reportRangeError(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `char[]` of length %d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(length)));
        }
    }

    public OutputStream _createDataOutputWrapper(DataOutput dataOutput) {
        return new DataOutputAsStream(dataOutput);
    }

    public InputStream _fileInputStream(File file) {
        return new FileInputStream(file);
    }

    public OutputStream _fileOutputStream(File file) {
        return new FileOutputStream(file);
    }

    public InputStream _optimizedStreamFromURL(URL url) {
        String host;
        return (!"file".equals(url.getProtocol()) || !((host = url.getHost()) == null || host.length() == 0) || url.getPath().indexOf(37) >= 0) ? url.openStream() : new FileInputStream(url.getPath());
    }

    public <T> T _reportRangeError(String str) {
        throw new IllegalArgumentException(str);
    }

    public abstract boolean canHandleBinaryNatively();

    public abstract boolean canParseAsync();

    public abstract boolean canUseSchema(FormatSchema formatSchema);

    public abstract JsonGenerator createGenerator(DataOutput dataOutput);

    public abstract JsonGenerator createGenerator(DataOutput dataOutput, JsonEncoding jsonEncoding);

    public abstract JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding);

    public abstract JsonGenerator createGenerator(OutputStream outputStream);

    public abstract JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding);

    public abstract JsonGenerator createGenerator(Writer writer);

    public abstract JsonParser createNonBlockingByteArrayParser();

    public abstract JsonParser createNonBlockingByteBufferParser();

    public abstract JsonParser createParser(DataInput dataInput);

    public abstract JsonParser createParser(File file);

    public abstract JsonParser createParser(InputStream inputStream);

    public abstract JsonParser createParser(Reader reader);

    public abstract JsonParser createParser(String str);

    public abstract JsonParser createParser(URL url);

    public abstract JsonParser createParser(byte[] bArr);

    public abstract JsonParser createParser(byte[] bArr, int i, int i3);

    public abstract JsonParser createParser(char[] cArr);

    public abstract JsonParser createParser(char[] cArr, int i, int i3);

    public abstract int getFactoryFeatures();

    public abstract int getFormatGeneratorFeatures();

    public abstract String getFormatName();

    public abstract int getFormatParserFeatures();

    public abstract Class<? extends FormatFeature> getFormatReadFeatureType();

    public abstract Class<? extends FormatFeature> getFormatWriteFeatureType();

    public abstract int getGeneratorFeatures();

    public abstract int getParserFeatures();

    public abstract boolean isEnabled(JsonFactory.Feature feature);

    public abstract boolean isEnabled(JsonGenerator.Feature feature);

    public abstract boolean isEnabled(JsonParser.Feature feature);

    public abstract boolean isEnabled(StreamReadFeature streamReadFeature);

    public abstract boolean isEnabled(StreamWriteFeature streamWriteFeature);

    public abstract boolean requiresPropertyOrdering();

    public abstract StreamReadConstraints streamReadConstraints();

    public abstract StreamWriteConstraints streamWriteConstraints();
}

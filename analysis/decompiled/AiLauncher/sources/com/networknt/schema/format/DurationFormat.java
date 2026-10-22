package com.networknt.schema.format;

import androidx.exifinterface.media.ExifInterface;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.SchemaContext;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class DurationFormat implements Format {
    private static final String DURATION = "duration";
    private static final Pattern STRICT = Pattern.compile("^(?:P\\d+W)|(?:P(?:\\d+Y)?(?:\\d+M)?(?:\\d+D)?(?:T(?:\\d+H)?(?:\\d+M)?(?:\\d+S)?)?)$", 2);
    private static final Pattern LAX = Pattern.compile("^(?:[-+]?)P(?:[-+]?[0-9]+Y)?(?:[-+]?[0-9]+M)?(?:[-+]?[0-9]+W)?(?:[-+]?[0-9]+D)?(?:T(?:[-+]?[0-9]+H)?(?:[-+]?[0-9]+M)?(?:[-+]?[0-9]+(?:[.,][0-9]{0,9})?S)?)?$", 2);

    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.duration";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return DURATION;
    }

    public boolean isStrictValidation(SchemaContext schemaContext) {
        return schemaContext.getSchemaRegistryConfig().isStrict(DURATION);
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, SchemaContext schemaContext, String str) {
        if (str == null) {
            return true;
        }
        if (str.endsWith("P") || str.endsWith(ExifInterface.GPS_DIRECTION_TRUE)) {
            return false;
        }
        return (isStrictValidation(schemaContext) ? STRICT : LAX).matcher(str).matches();
    }
}

package com.fasterxml.jackson.core.exc;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.RequestPayload;

/* loaded from: classes2.dex */
public abstract class StreamReadException extends JsonProcessingException {
    static final long serialVersionUID = 2;
    protected transient JsonParser _processor;
    protected RequestPayload _requestPayload;

    public StreamReadException(String str) {
        this(null, str, null, null);
    }

    public static JsonLocation _currentLocation(JsonParser jsonParser) {
        if (jsonParser == null) {
            return null;
        }
        return jsonParser.currentLocation();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this._requestPayload == null) {
            return message;
        }
        StringBuilder sbX = a.x(message, "\nRequest payload : ");
        sbX.append(this._requestPayload.toString());
        return sbX.toString();
    }

    public RequestPayload getRequestPayload() {
        return this._requestPayload;
    }

    public String getRequestPayloadAsString() {
        RequestPayload requestPayload = this._requestPayload;
        if (requestPayload != null) {
            return requestPayload.toString();
        }
        return null;
    }

    public abstract StreamReadException withParser(JsonParser jsonParser);

    public abstract StreamReadException withRequestPayload(RequestPayload requestPayload);

    public StreamReadException(JsonParser jsonParser, String str) {
        this(jsonParser, str, _currentLocation(jsonParser), null);
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, com.fasterxml.jackson.core.JacksonException
    public JsonParser getProcessor() {
        return this._processor;
    }

    public StreamReadException(JsonParser jsonParser, String str, Throwable th) {
        this(jsonParser, str, _currentLocation(jsonParser), th);
    }

    public StreamReadException(JsonParser jsonParser, String str, JsonLocation jsonLocation) {
        this(jsonParser, str, jsonLocation, null);
    }

    public StreamReadException(String str, JsonLocation jsonLocation, Throwable th) {
        this(null, str, jsonLocation, th);
    }

    public StreamReadException(JsonParser jsonParser, String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
        this._processor = jsonParser;
    }
}

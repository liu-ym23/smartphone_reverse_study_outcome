package com.networknt.schema;

import com.networknt.schema.Error;
import com.networknt.schema.MessageSourceError;
import com.networknt.schema.i18n.MessageFormatter;
import com.networknt.schema.i18n.MessageSource;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class MessageSourceError {

    public static class Builder extends BuilderSupport<Builder> {
        public Builder(MessageSource messageSource, Map<String, String> map) {
            super(messageSource, map);
        }

        @Override // com.networknt.schema.Error.BuilderSupport
        public Builder self() {
            return this;
        }
    }

    public static abstract class BuilderSupport<S> extends Error.BuilderSupport<S> {
        private final Map<String, String> errorMessage;
        private Locale locale;
        private final MessageSource messageSource;

        public BuilderSupport(MessageSource messageSource, Map<String, String> map) {
            this.messageSource = messageSource;
            this.errorMessage = map;
        }

        public static /* synthetic */ String c(BuilderSupport builderSupport, Object[] objArr) {
            MessageSource messageSource = builderSupport.messageSource;
            String str = builderSupport.messageKey;
            Locale locale = builderSupport.locale;
            if (locale == null) {
                locale = Locale.ROOT;
            }
            return messageSource.getMessage(str, locale, objArr);
        }

        @Override // com.networknt.schema.Error.BuilderSupport
        public Error build() {
            String str;
            Map<String, String> map = this.errorMessage;
            if (map != null) {
                String str2 = map.get("");
                Map<String, Object> map2 = this.details;
                if (map2 != null && map2.get("property") != null && (str = this.errorMessage.get(this.details.get("property"))) != null) {
                    str2 = str;
                }
                if (str2 != null && !"".equals(str2)) {
                    this.message = str2;
                }
            }
            if (this.message == null && this.messageSupplier == null && this.messageFormatter == null) {
                this.messageFormatter = new MessageFormatter() { // from class: com.networknt.schema.g
                    @Override // com.networknt.schema.i18n.MessageFormatter
                    public final String format(Object[] objArr) {
                        return MessageSourceError.BuilderSupport.c(this.f21970a, objArr);
                    }
                };
            }
            return super.build();
        }

        public S locale(Locale locale) {
            this.locale = locale;
            return self();
        }
    }

    public static Builder builder(MessageSource messageSource, Map<String, String> map) {
        return new Builder(messageSource, map);
    }
}

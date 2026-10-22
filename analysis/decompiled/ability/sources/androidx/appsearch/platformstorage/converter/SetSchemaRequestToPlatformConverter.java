package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.GenericDocument;
import android.app.appsearch.PackageIdentifier;
import android.app.appsearch.SchemaVisibilityConfig;
import android.app.appsearch.SetSchemaRequest;
import android.app.appsearch.SetSchemaResponse;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.Migrator;
import androidx.appsearch.app.SchemaVisibilityConfig;
import androidx.appsearch.app.SetSchemaResponse;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SetSchemaRequestToPlatformConverter {

    @RequiresApi(33)
    public static class ApiHelperForT {
        private ApiHelperForT() {
        }

        @DoNotInline
        public static void addRequiredPermissionsForSchemaTypeVisibility(SetSchemaRequest.Builder builder, String str, Set<Integer> set) {
            builder.addRequiredPermissionsForSchemaTypeVisibility(str, set);
        }
    }

    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addSchemaTypeVisibleToConfig(SetSchemaRequest.Builder builder, String str, Set<SchemaVisibilityConfig> set) {
            Iterator<SchemaVisibilityConfig> it = set.iterator();
            while (it.hasNext()) {
                builder.addSchemaTypeVisibleToConfig(str, toPlatformSchemaVisibilityConfig(it.next()));
            }
        }

        @DoNotInline
        public static void setPubliclyVisibleSchema(SetSchemaRequest.Builder builder, String str, PackageIdentifier packageIdentifier) {
            builder.setPubliclyVisibleSchema(str, packageIdentifier);
        }

        private static android.app.appsearch.SchemaVisibilityConfig toPlatformSchemaVisibilityConfig(SchemaVisibilityConfig schemaVisibilityConfig) {
            Preconditions.checkNotNull(schemaVisibilityConfig);
            SchemaVisibilityConfig.Builder builderC = androidx.appfunctions.a.c();
            List<androidx.appsearch.app.PackageIdentifier> allowedPackages = schemaVisibilityConfig.getAllowedPackages();
            for (int i = 0; i < allowedPackages.size(); i++) {
                builderC.addAllowedPackage(new PackageIdentifier(allowedPackages.get(i).getPackageName(), allowedPackages.get(i).getSha256Certificate()));
            }
            Iterator<Set<Integer>> it = schemaVisibilityConfig.getRequiredPermissions().iterator();
            while (it.hasNext()) {
                builderC.addRequiredPermissions(it.next());
            }
            androidx.appsearch.app.PackageIdentifier publiclyVisibleTargetPackage = schemaVisibilityConfig.getPubliclyVisibleTargetPackage();
            if (publiclyVisibleTargetPackage != null) {
                builderC.setPubliclyVisibleTargetPackage(new PackageIdentifier(publiclyVisibleTargetPackage.getPackageName(), publiclyVisibleTargetPackage.getSha256Certificate()));
            }
            return builderC.build();
        }
    }

    private SetSchemaRequestToPlatformConverter() {
    }

    public static SetSchemaResponse toJetpackSetSchemaResponse(android.app.appsearch.SetSchemaResponse setSchemaResponse) {
        Preconditions.checkNotNull(setSchemaResponse);
        SetSchemaResponse.Builder builderAddMigratedTypes = new SetSchemaResponse.Builder().addDeletedTypes(setSchemaResponse.getDeletedTypes()).addIncompatibleTypes(setSchemaResponse.getIncompatibleTypes()).addMigratedTypes(setSchemaResponse.getMigratedTypes());
        for (SetSchemaResponse.MigrationFailure migrationFailure : setSchemaResponse.getMigrationFailures()) {
            builderAddMigratedTypes.addMigrationFailure(new SetSchemaResponse.MigrationFailure(migrationFailure.getNamespace(), migrationFailure.getDocumentId(), migrationFailure.getSchemaType(), AppSearchResultToPlatformConverter.platformAppSearchResultToJetpack(migrationFailure.getAppSearchResult(), Function.identity())));
        }
        return builderAddMigratedTypes.build();
    }

    public static SetSchemaRequest toPlatformSetSchemaRequest(androidx.appsearch.app.SetSchemaRequest setSchemaRequest) {
        Preconditions.checkNotNull(setSchemaRequest);
        SetSchemaRequest.Builder builder = new SetSchemaRequest.Builder();
        Iterator<AppSearchSchema> it = setSchemaRequest.getSchemas().iterator();
        while (it.hasNext()) {
            builder.addSchemas(SchemaToPlatformConverter.toPlatformSchema(it.next()));
        }
        Iterator<String> it2 = setSchemaRequest.getSchemasNotDisplayedBySystem().iterator();
        while (it2.hasNext()) {
            builder.setSchemaTypeDisplayedBySystem(it2.next(), false);
        }
        for (Map.Entry<String, Set<androidx.appsearch.app.PackageIdentifier>> entry : setSchemaRequest.getSchemasVisibleToPackagesInternal().entrySet()) {
            for (androidx.appsearch.app.PackageIdentifier packageIdentifier : entry.getValue()) {
                builder.setSchemaTypeVisibilityForPackage(entry.getKey(), true, new PackageIdentifier(packageIdentifier.getPackageName(), packageIdentifier.getSha256Certificate()));
            }
        }
        if (!setSchemaRequest.getRequiredPermissionsForSchemaTypeVisibility().isEmpty()) {
            for (Map.Entry<String, Set<Set<Integer>>> entry2 : setSchemaRequest.getRequiredPermissionsForSchemaTypeVisibility().entrySet()) {
                Iterator<Set<Integer>> it3 = entry2.getValue().iterator();
                while (it3.hasNext()) {
                    ApiHelperForT.addRequiredPermissionsForSchemaTypeVisibility(builder, entry2.getKey(), it3.next());
                }
            }
        }
        if (!setSchemaRequest.getPubliclyVisibleSchemas().isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("Publicly visible schema are not supported on this AppSearch implementation.");
            }
            for (Map.Entry<String, androidx.appsearch.app.PackageIdentifier> entry3 : setSchemaRequest.getPubliclyVisibleSchemas().entrySet()) {
                androidx.appsearch.app.PackageIdentifier value = entry3.getValue();
                ApiHelperForV.setPubliclyVisibleSchema(builder, entry3.getKey(), new PackageIdentifier(value.getPackageName(), value.getSha256Certificate()));
            }
        }
        if (!setSchemaRequest.getSchemasVisibleToConfigs().isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("Schema visible to config are not supported on this AppSearch implementation.");
            }
            for (Map.Entry<String, Set<androidx.appsearch.app.SchemaVisibilityConfig>> entry4 : setSchemaRequest.getSchemasVisibleToConfigs().entrySet()) {
                ApiHelperForV.addSchemaTypeVisibleToConfig(builder, entry4.getKey(), entry4.getValue());
            }
        }
        for (Map.Entry<String, Migrator> entry5 : setSchemaRequest.getMigrators().entrySet()) {
            final Migrator value2 = entry5.getValue();
            builder.setMigrator(entry5.getKey(), new android.app.appsearch.Migrator() { // from class: androidx.appsearch.platformstorage.converter.SetSchemaRequestToPlatformConverter.1
                @Override // android.app.appsearch.Migrator
                public GenericDocument onDowngrade(int i, int i6, GenericDocument genericDocument) throws IllegalArgumentException {
                    androidx.appsearch.app.GenericDocument jetpackGenericDocument = GenericDocumentToPlatformConverter.toJetpackGenericDocument(genericDocument);
                    androidx.appsearch.app.GenericDocument genericDocumentOnDowngrade = value2.onDowngrade(i, i6, jetpackGenericDocument);
                    return jetpackGenericDocument.equals(genericDocumentOnDowngrade) ? genericDocument : GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocumentOnDowngrade);
                }

                @Override // android.app.appsearch.Migrator
                public GenericDocument onUpgrade(int i, int i6, GenericDocument genericDocument) throws IllegalArgumentException {
                    androidx.appsearch.app.GenericDocument jetpackGenericDocument = GenericDocumentToPlatformConverter.toJetpackGenericDocument(genericDocument);
                    androidx.appsearch.app.GenericDocument genericDocumentOnUpgrade = value2.onUpgrade(i, i6, jetpackGenericDocument);
                    return jetpackGenericDocument.equals(genericDocumentOnUpgrade) ? genericDocument : GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocumentOnUpgrade);
                }

                @Override // android.app.appsearch.Migrator
                public boolean shouldMigrate(int i, int i6) {
                    return value2.shouldMigrate(i, i6);
                }
            });
        }
        return builder.setForceOverride(setSchemaRequest.isForceOverride()).setVersion(setSchemaRequest.getVersion()).build();
    }
}

package org.bouncycastle.asn1.x500.style;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

/* loaded from: classes.dex */
public class BCStyle extends AbstractX500NameStyle {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;
    public static final ASN1ObjectIdentifier C;
    public static final ASN1ObjectIdentifier CN;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH;
    public static final ASN1ObjectIdentifier DC;
    public static final ASN1ObjectIdentifier DESCRIPTION;
    public static final ASN1ObjectIdentifier DMD_NAME;
    public static final ASN1ObjectIdentifier DN_QUALIFIER;
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;
    public static final ASN1ObjectIdentifier E;
    public static final ASN1ObjectIdentifier EmailAddress;
    public static final ASN1ObjectIdentifier GENDER;
    public static final ASN1ObjectIdentifier GENERATION;
    public static final ASN1ObjectIdentifier GIVENNAME;
    public static final ASN1ObjectIdentifier INITIALS;
    public static final X500NameStyle INSTANCE;
    public static final ASN1ObjectIdentifier JURISDICTION_C;
    public static final ASN1ObjectIdentifier JURISDICTION_L;
    public static final ASN1ObjectIdentifier JURISDICTION_ST;
    public static final ASN1ObjectIdentifier L;
    public static final ASN1ObjectIdentifier NAME;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH;
    public static final ASN1ObjectIdentifier O;
    public static final ASN1ObjectIdentifier ORGANIZATION_IDENTIFIER;
    public static final ASN1ObjectIdentifier OU;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
    public static final ASN1ObjectIdentifier POSTAL_CODE;
    public static final ASN1ObjectIdentifier PSEUDONYM;
    public static final ASN1ObjectIdentifier ROLE;
    public static final ASN1ObjectIdentifier SERIALNUMBER;
    public static final ASN1ObjectIdentifier SN;
    public static final ASN1ObjectIdentifier ST;
    public static final ASN1ObjectIdentifier STREET;
    public static final ASN1ObjectIdentifier SURNAME;
    public static final ASN1ObjectIdentifier T;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;
    public static final ASN1ObjectIdentifier UID;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
    public static final ASN1ObjectIdentifier UnstructuredAddress;
    public static final ASN1ObjectIdentifier UnstructuredName;
    protected final Hashtable defaultSymbols = AbstractX500NameStyle.copyHashTable(DefaultSymbols);
    protected final Hashtable defaultLookUp = AbstractX500NameStyle.copyHashTable(DefaultLookUp);

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierI = f.i("2.5.4.6");
        C = aSN1ObjectIdentifierI;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI2 = f.i("2.5.4.10");
        O = aSN1ObjectIdentifierI2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI3 = f.i("2.5.4.11");
        OU = aSN1ObjectIdentifierI3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI4 = f.i("2.5.4.12");
        T = aSN1ObjectIdentifierI4;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI5 = f.i("2.5.4.3");
        CN = aSN1ObjectIdentifierI5;
        SN = f.i("2.5.4.5");
        ASN1ObjectIdentifier aSN1ObjectIdentifierI6 = f.i("2.5.4.9");
        STREET = aSN1ObjectIdentifierI6;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI7 = f.i("2.5.4.5");
        SERIALNUMBER = aSN1ObjectIdentifierI7;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI8 = f.i("2.5.4.7");
        L = aSN1ObjectIdentifierI8;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI9 = f.i("2.5.4.8");
        ST = aSN1ObjectIdentifierI9;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI10 = f.i("2.5.4.4");
        SURNAME = aSN1ObjectIdentifierI10;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI11 = f.i("2.5.4.42");
        GIVENNAME = aSN1ObjectIdentifierI11;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI12 = f.i("2.5.4.43");
        INITIALS = aSN1ObjectIdentifierI12;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI13 = f.i("2.5.4.44");
        GENERATION = aSN1ObjectIdentifierI13;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI14 = f.i("2.5.4.45");
        UNIQUE_IDENTIFIER = aSN1ObjectIdentifierI14;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI15 = f.i("2.5.4.13");
        DESCRIPTION = aSN1ObjectIdentifierI15;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI16 = f.i("2.5.4.15");
        BUSINESS_CATEGORY = aSN1ObjectIdentifierI16;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI17 = f.i("2.5.4.17");
        POSTAL_CODE = aSN1ObjectIdentifierI17;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI18 = f.i("2.5.4.46");
        DN_QUALIFIER = aSN1ObjectIdentifierI18;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI19 = f.i("2.5.4.65");
        PSEUDONYM = aSN1ObjectIdentifierI19;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI20 = f.i("2.5.4.72");
        ROLE = aSN1ObjectIdentifierI20;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = X509ObjectIdentifiers.id_pda;
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern = aSN1ObjectIdentifier.branch("1").intern();
        DATE_OF_BIRTH = aSN1ObjectIdentifierIntern;
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern2 = aSN1ObjectIdentifier.branch("2").intern();
        PLACE_OF_BIRTH = aSN1ObjectIdentifierIntern2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern3 = aSN1ObjectIdentifier.branch("3").intern();
        GENDER = aSN1ObjectIdentifierIntern3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern4 = aSN1ObjectIdentifier.branch("4").intern();
        COUNTRY_OF_CITIZENSHIP = aSN1ObjectIdentifierIntern4;
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern5 = aSN1ObjectIdentifier.branch("5").intern();
        COUNTRY_OF_RESIDENCE = aSN1ObjectIdentifierIntern5;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI21 = f.i("1.3.36.8.3.14");
        NAME_AT_BIRTH = aSN1ObjectIdentifierI21;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI22 = f.i("2.5.4.16");
        POSTAL_ADDRESS = aSN1ObjectIdentifierI22;
        DMD_NAME = f.i("2.5.4.54");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = X509ObjectIdentifiers.id_at_name;
        NAME = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = X509ObjectIdentifiers.id_at_organizationIdentifier;
        ORGANIZATION_IDENTIFIER = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = aSN1ObjectIdentifier7;
        E = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        DC = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("1.3.6.1.4.1.311.60.2.1.3");
        JURISDICTION_C = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("1.3.6.1.4.1.311.60.2.1.2");
        JURISDICTION_ST = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("1.3.6.1.4.1.311.60.2.1.1");
        JURISDICTION_L = aSN1ObjectIdentifier12;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(aSN1ObjectIdentifierI, "C");
        hashtable.put(aSN1ObjectIdentifierI2, "O");
        hashtable.put(aSN1ObjectIdentifierI4, "T");
        hashtable.put(aSN1ObjectIdentifierI3, "OU");
        hashtable.put(aSN1ObjectIdentifierI5, "CN");
        hashtable.put(aSN1ObjectIdentifierI8, "L");
        hashtable.put(aSN1ObjectIdentifierI9, "ST");
        hashtable.put(aSN1ObjectIdentifierI7, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier5, "E");
        hashtable.put(aSN1ObjectIdentifier8, "DC");
        hashtable.put(aSN1ObjectIdentifier9, "UID");
        hashtable.put(aSN1ObjectIdentifierI6, "STREET");
        hashtable.put(aSN1ObjectIdentifierI10, "SURNAME");
        hashtable.put(aSN1ObjectIdentifierI11, "GIVENNAME");
        hashtable.put(aSN1ObjectIdentifierI12, "INITIALS");
        hashtable.put(aSN1ObjectIdentifierI13, "GENERATION");
        hashtable.put(aSN1ObjectIdentifierI15, "DESCRIPTION");
        hashtable.put(aSN1ObjectIdentifierI20, "ROLE");
        hashtable.put(aSN1ObjectIdentifier7, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier6, "unstructuredName");
        hashtable.put(aSN1ObjectIdentifierI14, "UniqueIdentifier");
        hashtable.put(aSN1ObjectIdentifierI18, "DN");
        hashtable.put(aSN1ObjectIdentifierI19, "Pseudonym");
        hashtable.put(aSN1ObjectIdentifierI22, "PostalAddress");
        hashtable.put(aSN1ObjectIdentifierI21, "NameAtBirth");
        hashtable.put(aSN1ObjectIdentifierIntern4, "CountryOfCitizenship");
        hashtable.put(aSN1ObjectIdentifierIntern5, "CountryOfResidence");
        hashtable.put(aSN1ObjectIdentifierIntern3, "Gender");
        hashtable.put(aSN1ObjectIdentifierIntern2, "PlaceOfBirth");
        hashtable.put(aSN1ObjectIdentifierIntern, "DateOfBirth");
        hashtable.put(aSN1ObjectIdentifierI17, "PostalCode");
        hashtable.put(aSN1ObjectIdentifierI16, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier2, "TelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier3, "Name");
        hashtable.put(aSN1ObjectIdentifier4, "organizationIdentifier");
        hashtable.put(aSN1ObjectIdentifier10, "jurisdictionCountry");
        hashtable.put(aSN1ObjectIdentifier11, "jurisdictionState");
        hashtable.put(aSN1ObjectIdentifier12, "jurisdictionLocality");
        hashtable2.put("c", aSN1ObjectIdentifierI);
        hashtable2.put("o", aSN1ObjectIdentifierI2);
        hashtable2.put("t", aSN1ObjectIdentifierI4);
        hashtable2.put("ou", aSN1ObjectIdentifierI3);
        hashtable2.put("cn", aSN1ObjectIdentifierI5);
        hashtable2.put("l", aSN1ObjectIdentifierI8);
        hashtable2.put("st", aSN1ObjectIdentifierI9);
        hashtable2.put("sn", aSN1ObjectIdentifierI10);
        hashtable2.put("serialnumber", aSN1ObjectIdentifierI7);
        hashtable2.put("street", aSN1ObjectIdentifierI6);
        hashtable2.put("emailaddress", aSN1ObjectIdentifier5);
        hashtable2.put("dc", aSN1ObjectIdentifier8);
        hashtable2.put("e", aSN1ObjectIdentifier5);
        hashtable2.put("uid", aSN1ObjectIdentifier9);
        hashtable2.put("surname", aSN1ObjectIdentifierI10);
        hashtable2.put("givenname", aSN1ObjectIdentifierI11);
        hashtable2.put("initials", aSN1ObjectIdentifierI12);
        hashtable2.put("generation", aSN1ObjectIdentifierI13);
        hashtable2.put("description", aSN1ObjectIdentifierI15);
        hashtable2.put("role", aSN1ObjectIdentifierI20);
        hashtable2.put("unstructuredaddress", aSN1ObjectIdentifier7);
        hashtable2.put("unstructuredname", aSN1ObjectIdentifier6);
        hashtable2.put("uniqueidentifier", aSN1ObjectIdentifierI14);
        hashtable2.put("dn", aSN1ObjectIdentifierI18);
        hashtable2.put("pseudonym", aSN1ObjectIdentifierI19);
        hashtable2.put("postaladdress", aSN1ObjectIdentifierI22);
        hashtable2.put("nameatbirth", aSN1ObjectIdentifierI21);
        hashtable2.put("countryofcitizenship", aSN1ObjectIdentifierIntern4);
        hashtable2.put("countryofresidence", aSN1ObjectIdentifierIntern5);
        hashtable2.put("gender", aSN1ObjectIdentifierIntern3);
        hashtable2.put("placeofbirth", aSN1ObjectIdentifierIntern2);
        hashtable2.put("dateofbirth", aSN1ObjectIdentifierIntern);
        hashtable2.put("postalcode", aSN1ObjectIdentifierI17);
        hashtable2.put("businesscategory", aSN1ObjectIdentifierI16);
        hashtable2.put("telephonenumber", aSN1ObjectIdentifier2);
        hashtable2.put("name", aSN1ObjectIdentifier3);
        hashtable2.put("organizationidentifier", aSN1ObjectIdentifier4);
        hashtable2.put("jurisdictioncountry", aSN1ObjectIdentifier10);
        hashtable2.put("jurisdictionstate", aSN1ObjectIdentifier11);
        hashtable2.put("jurisdictionlocality", aSN1ObjectIdentifier12);
        INSTANCE = new BCStyle();
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return (aSN1ObjectIdentifier.equals((ASN1Primitive) EmailAddress) || aSN1ObjectIdentifier.equals((ASN1Primitive) DC)) ? new DERIA5String(str) : aSN1ObjectIdentifier.equals((ASN1Primitive) DATE_OF_BIRTH) ? new ASN1GeneralizedTime(str) : (aSN1ObjectIdentifier.equals((ASN1Primitive) C) || aSN1ObjectIdentifier.equals((ASN1Primitive) SERIALNUMBER) || aSN1ObjectIdentifier.equals((ASN1Primitive) DN_QUALIFIER) || aSN1ObjectIdentifier.equals((ASN1Primitive) TELEPHONE_NUMBER) || aSN1ObjectIdentifier.equals((ASN1Primitive) JURISDICTION_C)) ? new DERPrintableString(str) : super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public RDN[] fromString(String str) {
        return IETFUtils.rDNsFromString(str, this);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String[] oidToAttrNames(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IETFUtils.findAttrNamesForOID(aSN1ObjectIdentifier, this.defaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String oidToDisplayName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) this.defaultSymbols.get(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String toString(X500Name x500Name) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (RDN rdn : x500Name.getRDNs()) {
            if (z) {
                z = false;
            } else {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            IETFUtils.appendRDN(sb, rdn, this.defaultSymbols);
        }
        return sb.toString();
    }
}
